import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * panel holding the guest table for the guest tab
 * @author Anton Akov
 *
 */
public class GuestTablePanel extends JPanel
{
   String[] columns = {"№", "Name", "Dates", "Booking"};
   
   Object[][] data;
   
   JTextField text;
   JButton butt;
   JTable table;
   JPanel fortable;
   ActionListener listener;
   TableModel model;
   TableRowSorter<TableModel> sorter;
   JScrollPane pane;
   JLabel label;
   int dates;
   int rooms;
   
   
   JButton editNoteB;
   JButton checkOutB;
   JButton editFormB;
   Bookings bookings;
   
   
   GuestTablePanel thisTable;
   /**
    * takes selected booking and the buttons to control the table
    * @param b selcted booking
    * @param searchB search button
    * @param searchT search text for button
    * @param editN edit note button
    * @param checkout checkout button
    * @param editF meditate button
    */
   public GuestTablePanel(Bookings b, JButton searchB, JTextField searchT, JButton editN, JButton checkout, JButton editF )
   {
      text = searchT;
      butt = searchB;
      bookings  = b;
      editNoteB = editN;
      checkOutB = checkout;
      editFormB = editF;
      
      listener = new ButtonListener();
      
      
      editNoteB.addActionListener(listener);
      checkOutB.addActionListener(listener);
      editFormB.addActionListener(listener);
      
      
      
       construct();
       
       thisTable = this;
       

   }
   /**
    * creates table and pane
    */
   private void construct()
   {
      dates = 0;
      rooms = 0;
      int i = 0;
      int j = 0;
      String tempRoomString = "";
      String tempDateString = "";
      data = new Object[bookings.getNumberOfCheckedIn()][4];
      while(i<bookings.getCheckedIn().size())
      {
         //if(bookings.get(i).isCheckedIn()==false){i++;continue;}
         while(j<bookings.getCheckedIn().get(i).getBookedRooms().length)
         {
            tempRoomString = tempRoomString + bookings.getCheckedIn().get(i).getBookedRooms()[j].getRoomNumber()+", ";
            j++;
         }
         data[i][0] =  tempRoomString.substring(0, tempRoomString.length()-2);
         if(rooms<j)rooms = j;
         j=0;
         tempRoomString = "";
         
         //TODO data[i][1] = String.valueOf(Rooms.get(i).getType());
         //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
         data[i][1] = bookings.getCheckedIn().get(i).getName();
         //data[i][2] = (boolean)bookings.get(i).isCheckedIn();
         /*while(j<Rooms.get(i).getBookings().getList().size())
         {
            tempDateString = tempDateString + Rooms.get(i).getBookings().get(j).getDates() + "    //    ";
            
            j++;
            
         }
         if(j!=0)tempDateString = tempDateString.substring(0, tempDateString.length()-10);
         if(j>dates)dates = j;
         j=0;*/
         data[i][2] = bookings.getCheckedIn().get(i).getDates();
         data[i][3] = bookings.getCheckedIn().get(i);
         i++;
      }
      model = new DefaultTableModel(data, columns) {
         public Class getColumnClass(int column) {
           Class returnValue;
           if ((column >= 0) && (column < getColumnCount())) {
             returnValue = getValueAt(0, column).getClass();
           } else {
             returnValue = Object.class;
           }
           return returnValue;
         }
         @Override
         public boolean isCellEditable(int row, int column) {
             //Only the third column
             return false;
         }
       };
      table = new JTable(model);
      DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
      centerRenderer.setHorizontalAlignment( JLabel.CENTER );
      
      DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
      rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
      
      
      //TableColumn column = table.getColumnModel().getColumn(3);
      //MultiLineHeaderRenderer headerRenderer = new MultiLineHeaderRenderer();
      //SwingConstants.LEFT, SwingConstants.BOTTOM);
      //column.setHeaderRenderer(headerRenderer);
      
      
      TableColumn column;
      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      column = null;
      for(int ij = 0;ij<4;ij++)
      {
         column = table.getColumnModel().getColumn(ij);
         switch(ij)
         {
            case 0 : column.setPreferredWidth(32+5);column.setCellRenderer(rightRenderer);break;
            case 1 : column.setPreferredWidth(180);column.setCellRenderer(centerRenderer);break;
            //case 2 : column.setPreferredWidth(80);break;
            case 2 : column.setMinWidth(310);break;
            case 3 : table.getColumnModel().removeColumn(column);
         }
      }
      sorter = new TableRowSorter<TableModel>(model);
      table.setRowSorter(sorter);
      pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      add(pane, BorderLayout.CENTER);
      listener = new ButtonListener();
      butt.addActionListener(listener);
      pane.setPreferredSize(new Dimension(530,250));
      /*JViewport viewport = new JViewport();
      viewport.setSize(400, 200);
      pane.setViewport(viewport);*/
      
   }
   /**
    * removes pane and remakes the table
    */
   public void remake()
   {
      remove(pane);
      construct();
      validate();
   }
   /**
    *  makes main update all Tables
    */
   public void updateMain()
   {
      MAIN mainW = (MAIN) SwingUtilities.getWindowAncestor(this);
      mainW.remakeAllTables();
   }
   /**
    * 
    * button listner for the GuestTablePanel
    *
    */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource() == butt)
         {
            
            String txt = text.getText();
            if (txt.length() == 0) {
              sorter.setRowFilter(null);
            } else {
              sorter.setRowFilter(RowFilter.regexFilter(txt));
            }
         }
         
         if(e.getSource() == editNoteB)
         {
            System.out.println("Edit Pressed");
            
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 3);
            
            System.out.println(tablerow);
            
            new NoteEdit(selected);
            
            System.out.println("window called");
         }
         if(e.getSource() == checkOutB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 3);
            
            new CheckOut(bookings, selected, thisTable);
            //bookings.delete(selected);
            updateMain();
         }
         if(e.getSource() == editFormB)
         {
            int tablerow = table.getSelectedRow();
            tablerow = table.convertRowIndexToModel(tablerow);
            Booking selected = (Booking) table.getModel().getValueAt(tablerow, 3);
            new CheckIn(selected, bookings, (GuestTablePanel) thisTable);
            
         }
         
      }
   }
}
