package hust.soict.hedspi.aims.screen;
import javax.swing.*;
import hust.soict.hedspi.aims.cart.HungNT_Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.HungNT_Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HungNT_StoreScreen extends JFrame {
	private static final long serialVersionUID = -3913201726916721062L;
	private HungNT_Store store;
    private Container cp;
    private HungNT_Cart cart;
    JPanel HungNT_createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(HungNT_createMenuBar());
        north.add(HungNT_createHeader());
        return north;
    }

    JMenuBar HungNT_createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HungNT_AddBookStoreScreen(store).setVisible(true);
            }
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HungNT_AddCDStoreScreen(store).setVisible(true);
            }
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                new HungNT_AddDVDStoreScreen(store).setVisible(true);
            }
        });
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel HungNT_createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);

        JButton cart1 = new JButton("View cart");
        cart1.setPreferredSize(new Dimension(100,50));
        cart1.setMaximumSize(new Dimension(100,50));
        cart1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HungNT_CartScreen(cart).setVisible(true);
            }
        });
        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart1);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel HungNT_createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        LinkedList<HungNT_Media> mediaStore = store.getItemsInStore();
        for(HungNT_Media media : mediaStore) {
        	HungNT_MediaStore cell = new HungNT_MediaStore(media, cart);
            center.add(cell);
        }
        return center;
    }

    public HungNT_StoreScreen(HungNT_Store store, HungNT_Cart myCart) {
        this.store  = store;
        this.cart = myCart;
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(HungNT_createNorth(),BorderLayout.NORTH);
        cp.add(HungNT_createCenter(),BorderLayout.CENTER);
        setVisible(true);
        setTitle("Store");
        setSize(1024,768);
    }


    private class HungNT_AddDVDStoreScreen extends JFrame {
		private static final long serialVersionUID = 1L;

		public HungNT_AddDVDStoreScreen(HungNT_Store store) {
            this.setLayout(new GridLayout(4, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);

            this.setTitle("Add DVD");
            this.setSize(300, 100);
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HungNT_DigitalVideoDisc dvd = new HungNT_DigitalVideoDisc(2, title.getText(), category.getText(), Float.parseFloat(cost.getText()));
                    store.addMedia(dvd);
                    cp.add(HungNT_createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            this.setVisible(true);
        }
    }

    private class HungNT_AddCDStoreScreen extends JFrame {
		private static final long serialVersionUID = 1L;

		public HungNT_AddCDStoreScreen(HungNT_Store store) {
            this.setLayout(new GridLayout(7, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);
            this.add(new JLabel("Enter artist: "));
            TextField artist = new TextField(10);
            this.add(artist);
            this.setTitle("Add CD");
            this.add(new JLabel("Number of tracks: "));
            TextField numberOfTracks = new TextField(10);
            this.add(numberOfTracks);
            this.pack();
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HungNT_CompactDisc dvd = new HungNT_CompactDisc(2, title.getText(), category.getText(), Float.parseFloat(cost.getText()),artist.getText(),new ArrayList<HungNT_Track>());
                    store.addMedia(dvd);
                    cp.add(HungNT_createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            this.setVisible(true);
        }
    }
    
    private class HungNT_AddBookStoreScreen extends JFrame {
		private static final long serialVersionUID = -145726792135069230L;

		public HungNT_AddBookStoreScreen(HungNT_Store store) {
            this.setLayout(new GridLayout(7, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);
            this.add(new JLabel("Enter author (If multiple authors, use commas to fill in): "));
            TextField author = new TextField(10);
            this.add(author);
            this.setTitle("Add Book");
            this.pack();
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	String[] authorArray = author.getText().split(",");
                    List<String> authors = new ArrayList<String>();
                    
                    for (String a : authorArray) {
                        authors.add(a.trim());
                    }
            		HungNT_Book book = new HungNT_Book(4, title.getText(), category.getText(), Float.parseFloat(cost.getText()), authors);
            		store.addMedia(book);
                    cp.add(HungNT_createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                    author.setText(null);
                }
            });
            this.setVisible(true);
        }
    }
    
    public static void main(String[] args) {
    	HungNT_DigitalVideoDisc dvd = new HungNT_DigitalVideoDisc(1, "Jurassic World", "Action", 30.75f,
				"Colin Trevorrow", 124);
    	HungNT_DigitalVideoDisc dvd0 = new HungNT_DigitalVideoDisc(2, "The Tomorrow War", "Science Fiction", 30.75f,
				"Chris McKay", 138);

    	ArrayList<HungNT_Track> tracks = new ArrayList<HungNT_Track>();
		tracks.add(new HungNT_Track("Like I'm gonna lose you", 4));
		tracks.add(new HungNT_Track("Let me down slowly", 3));
		HungNT_CompactDisc cd = new HungNT_CompactDisc(2, "Ban nhac buon", "Nhac Au - My", 10f, "Various artists", tracks);

        ArrayList<HungNT_Track> hsr = new ArrayList<HungNT_Track>();
        hsr.add(new HungNT_Track("Hope Is the Thing With Feathers", 4));
        hsr.add(new HungNT_Track("Sway to My Beat in Cosmos", 3));
        hsr.add(new HungNT_Track("If I Can Stop One Heart From Breaking", 3));
        hsr.add(new HungNT_Track("Had I Not Seen the Sun", 2));
        hsr.add(new HungNT_Track("Sway to My Beat in Cosmos (Instrumental)", 3));
        hsr.add(new HungNT_Track("If I Can Stop One Heart from Breaking (Instrumental)", 3));
        hsr.add(new HungNT_Track("Hope is the Thing with Feathers (Instrumental)", 4));
        hsr.add(new HungNT_Track("Had I Not Seen the Sun (Instrumental)", 2));
        HungNT_CompactDisc cd2 = new HungNT_CompactDisc(3, "INSIDE", "Penacony music", 37.25f, "Robin", hsr);

        List<String> authors = new ArrayList<String>();
		authors.add("Fujiko F. Fujio");
		HungNT_Book book = new HungNT_Book(4, "Doraemon", "Manga", 0.79f, authors);
		
        List<String> authors2 = new ArrayList<String>();
        authors2.add("Tappei Nagatsuki");
        HungNT_Book book2 = new HungNT_Book(5, "Re:Zero kara Hajimeru Isekai Seikatsu", "Light novel", 21.01f, authors2);
        
        HungNT_Store store = new HungNT_Store();
        store.addMedia(cd);
        store.addMedia(cd2);
        store.addMedia(dvd);
        store.addMedia(dvd0);
        store.addMedia(book);
        store.addMedia(book2);

        HungNT_Cart myCart = new HungNT_Cart();
        new HungNT_StoreScreen(store,myCart);
    }
}