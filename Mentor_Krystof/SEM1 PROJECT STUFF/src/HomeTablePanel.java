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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Class/table for the homeTab which holds all the events for the day
 * @author Anton Akov
 *
 */
public class HomeTablePanel extends JPanel
{
   String[] columns = {"№", "Name", "Action", "Time"};
   
   Object[][] data;
   

   JTable table;
   JPanel fortable;
   ActionListener listener;
   TableModel model;
   TableRowSorter<TableModel> sorter;
   JScrollPane pane;
   JLabel label;
   int dates;
   int rooms;
   Bookings bookings;
   /**
    * Default constructor just takes all bookings
    * @param b all bookings
    */
   public HomeTablePanel(Bookings b)
   {
      bookings = b;
      dates = 0;
      rooms = 0;
         
       construct();
   }
   /**
    * Creates the table and pane
    */
   private void construct()
   {
      
      int i = 0;
      int j = 0;
      int cnt = 0;
      String tempRoomString = "";
      String tempDateString = "";
      String tempActionString = "";
      data = new Object[bookings.getNumberOfToday()][5];
      while(i<bookings.getList().size())
      {
         if(!bookings.get(i).isBookingToday()){i++;continue;}
         while(j<bookings.get(i).getBookedRooms().length)
         {
            tempRoomString = tempRoomString + bookings.get(i).getBookedRooms()[j].getRoomNumber()+", ";
            j++;
         }
         data[cnt][0] = tempRoomString.substring(0, tempRoomString.length()-2);
         if(rooms<j)rooms = j;
         j=0;
         tempRoomString = "";
         
         //TODO data[i][1] = String.valueOf(Rooms.get(i).getType());
         //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
         data[cnt][1] = bookings.get(i).getName();
         
         if(bookings.get(i).getDates().isToday(bookings.get(i).getDates().getCheckIn()))tempActionString = "Arrival";
         else tempActionString = "Departure";
         data[cnt][2] = tempActionString;
         /*while(j<Rooms.get(i).getBookings().getList().size())
         {
            tempDateString = tempDateString + Rooms.get(i).getBookings().get(j).getDates() + "    //    ";
            
            j++;
            
         }
         if(j!=0)tempDateString = tempDateString.substring(0, tempDateString.length()-10);
         if(j>dates)dates = j;
         j=0;*/
         data[cnt][3] = bookings.get(i).getDates().getCalendarString();
         i++;
         cnt++;
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
            case 0 : column.setPreferredWidth(32+(rooms-1)*5);column.setCellRenderer(rightRenderer);break;
            case 1 : column.setPreferredWidth(180);column.setCellRenderer(centerRenderer);break;
            case 2 : column.setPreferredWidth(80);column.setCellRenderer(centerRenderer);break;
            case 3 : column.setMinWidth(105-((rooms-1)*5));break;
         }
      }
      sorter = new TableRowSorter<TableModel>(model);
      table.setRowSorter(sorter);
      pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      add(pane, BorderLayout.CENTER);
      pane.setPreferredSize(new Dimension(350,250));
      /*JViewport viewport = new JViewport();
      viewport.setSize(400, 200);
      pane.setViewport(viewport);*/
      
   }
   /**
    * remakes this table
    */
   public void remake()
   {
      remove(pane);
      construct();
      validate();
   }
}