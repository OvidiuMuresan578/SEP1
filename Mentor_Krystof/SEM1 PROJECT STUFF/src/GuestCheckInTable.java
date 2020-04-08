import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 * Table used in the CheckIn window to display guest information
 * @author Anton Akov
 *
 */
public class GuestCheckInTable extends JPanel
{
   
   String[] columns = {"Name", "Adress", "Phone", "E-mail", "Staying", "Room", "Passport Number", "Date of birth", "GuestObject", "BookingObject" };
   
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
   
   ArrayList<Guest> guests;
   Booking booking;
   JButton addB;
   JButton editB;
   JButton deleteB;
   Object thispanel;
   
   /**
    * default constructor, takes single booking as argument
    * @param b booking the table is buit from
    */
   public GuestCheckInTable(Booking b)
   {
      booking = b;
      guests = b.getGuestsClone();
      
      construct();
   }
   /**
    * method that creates the whole
    */
   private void construct()
   {
      int i = 0;
      int j = 0;
      String tempRoomString = "";
      String tempDateString = "";
      data = new Object[guests.size()][10];
      while(i<guests.size())
      {
         /*while(j<bookings.get(i).getBookedRooms().length)
         {
            tempRoomString = tempRoomString + bookings.get(i).getBookedRooms()[j].getRoomNumber()+", ";
            j++;
         }*/
         data[i][0] = guests.get(i).getName();
         /*if(rooms<j)rooms = j;
         j=0;
         tempRoomString = "";
         */
   //TODO data[i][1] = String.valueOf(Rooms.get(i).getType());
            //0-suite, 1-2bedroom suite, 2-3bedroomsuite, 3-singleroom, 4-doubleroomKingsize, 5-doubleroom Double
            data[i][1] = guests.get(i).getHomeAdress();
            data[i][2] = guests.get(i).getPhone();
            /*while(j<Rooms.get(i).getBookings().getList().size())
            {
               tempDateString = tempDateString + Rooms.get(i).getBookings().get(j).getDates() + "    //    ";
               
               j++;
               
            }
            if(j!=0)tempDateString = tempDateString.substring(0, tempDateString.length()-10);
            if(j>dates)dates = j;
            j=0;*/
            data[i][3] = guests.get(i).getEmail();
            
            data[i][4] = booking.getDates();
            
            data[i][5] = guests.get(i).getRoomNum();
            data[i][6] = guests.get(i).getPassportNumber();
            data[i][7] = guests.get(i).getDateOfBirth();
            data[i][8] = guests.get(i);
            data[i][9] = booking;
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
         for(int ii = 0;ii<9;ii++)
         {
            column = table.getColumnModel().getColumn(ii);
            switch(ii)
            {
               case 0 : column.setPreferredWidth(150);break;
               case 1 : column.setPreferredWidth(180);column.setCellRenderer(centerRenderer);break;
               case 2 : column.setPreferredWidth(80);break;
               case 4 : column.setMinWidth(300);break;
               case 8 : table.getColumnModel().removeColumn(column);
               column = table.getColumnModel().getColumn(ii);
                        table.getColumnModel().removeColumn(column);
                        break;
               case 9 : table.getColumnModel().removeColumn(column);break;
               
            }
         }
         sorter = new TableRowSorter<TableModel>(model);
         table.setRowSorter(sorter);
         pane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
         add(pane, BorderLayout.CENTER);
         
         
         
         pane.setPreferredSize(new Dimension(400,200));
         /*JViewport viewport = new JViewport();
         viewport.setSize(400, 200);
         pane.setViewport(viewport);*/
         
      }
   	/**
   	 * returns the currently selected guest in the table
   	 * @return Guest obecject of :D
   	 * 
   	 */
      public Guest getSelectedGuest()
      {
         int tablerow = table.getSelectedRow();
         tablerow = table.convertRowIndexToModel(tablerow);
         Guest selected = (Guest) table.getModel().getValueAt(tablerow, 8);
         return selected;
      }
     /** 
      * remakes the table  
      */
      public void remake()
      {
         remove(pane);
         construct();
         validate();
      }
}