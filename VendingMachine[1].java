import java.text.DecimalFormat;
import static javax.swing.JOptionPane.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class VendingMachine extends JFrame
implements ActionListener
{

//datahandler
static DataHandler dh;

//changeFrame
JFrame changeFrame = new JFrame("Please Take the remaining money");
JLabel selectLabel = new JLabel("Please select your items:");

//All objects for Product 1:
ImageIcon productImage1 = new ImageIcon("images/products/productImage1.png");
JButton product1 = new JButton("", productImage1);
JLabel product1des = new JLabel("Kurkure", JLabel.CENTER);
JLabel product1price = new JLabel("₹20", JLabel.CENTER);

//All objects for Product 2:
ImageIcon productImage2 = new ImageIcon("images/products/productImage2.png");
JButton product2 = new JButton("", productImage2);
JLabel product2des = new JLabel("Protein Bar", JLabel.CENTER);
JLabel product2price = new JLabel("₹45", JLabel.CENTER);

//All objects for Product 3:
ImageIcon productImage3 = new ImageIcon("images/products/productImage3.png");
JButton product3 = new JButton("", productImage3);
JLabel product3des = new JLabel("Coca Cola", JLabel.CENTER);
JLabel product3price = new JLabel("₹35", JLabel.CENTER);

//All objects for Product 4:
ImageIcon productImage4 = new ImageIcon("images/products/productImage4.png");
JButton product4 = new JButton("", productImage4);
JLabel product4des = new JLabel("Oreo", JLabel.CENTER);
JLabel product4price = new JLabel("₹10", JLabel.CENTER);

//All objects for product 5:
ImageIcon productImage5 = new ImageIcon("images/products/productImage5.png");
JButton product5 = new JButton("", productImage5);
JLabel product5des = new JLabel("Bisleri", JLabel.CENTER);
JLabel product5price = new JLabel("₹20", JLabel.CENTER);

//All objects for product 6:
ImageIcon productImage6 = new ImageIcon("images/products/productImage6.png");
JButton product6 = new JButton("", productImage6);
JLabel product6des = new JLabel("KitKat", JLabel.CENTER);
JLabel product6price = new JLabel("₹20", JLabel.CENTER);

//All objects for product 7:
ImageIcon productImage7 = new ImageIcon("images/products/productImage7.png");
JButton product7 = new JButton("", productImage7);
JLabel product7des = new JLabel("DairyMilk Silk", JLabel.CENTER);
JLabel product7price = new JLabel("₹85", JLabel.CENTER);

//All objects for product 8:
ImageIcon productImage8 = new ImageIcon("images/products/productImage8.png");
JButton product8 = new JButton("", productImage8);
JLabel product8des = new JLabel("Amul Kool", JLabel.CENTER);
JLabel product8price = new JLabel("₹20", JLabel.CENTER);

//All objects for product 9:
ImageIcon productImage9 = new ImageIcon("images/products/productImage9.png");
JButton product9 = new JButton("", productImage9);
JLabel product9des = new JLabel("Appy Fizz", JLabel.CENTER);
JLabel product9price = new JLabel("₹30", JLabel.CENTER);

//All objects for product 10:
ImageIcon productImage10 = new ImageIcon("images/products/productImage10.png");
JButton product10 = new JButton("", productImage10);
JLabel product10des = new JLabel("Bhujia", JLabel.CENTER);
JLabel product10price = new JLabel("₹10", JLabel.CENTER);

//Horizontal/Vertical Rules as buttons for simplicity and layout
JButton ruleH = new JButton("");
JButton ruleV = new JButton("");
JButton ruleV2 = new JButton("");

//selected items section
JLabel selectedLabel = new JLabel("You have selected the following items:");
JTextArea selectedItems = new JTextArea(12,250);

//Total price:
JLabel selectedItemTotalLabel = new JLabel("Total - Please insert:");
JTextField selectedItemTotal = new JTextField("₹0.00", 30);

//Money section:
//Label:
JLabel moneyInputLabel = new JLabel("Please input your money:");

//Money buttons with imageIcons:
ImageIcon fiveRupeeImage = new ImageIcon("images/currency/5.jpg");
JButton fiveRupeeButton = new JButton("", fiveRupeeImage);
ImageIcon tenRupeeImage = new ImageIcon("images/currency/10.jpg");
JButton tenRupeeButton = new JButton("", tenRupeeImage);
ImageIcon twentyRupeeImage = new ImageIcon("images/currency/20.jpg");
JButton twentyRupeeButton = new JButton("", twentyRupeeImage);
ImageIcon fiftyRupeeImage = new ImageIcon("images/currency/50.jpg");
JButton fiftyRupeeButton = new JButton("", fiftyRupeeImage);
ImageIcon hundredRupeeImage = new ImageIcon("images/currency/100.jpg");
JButton hundredRupeeButton = new JButton("", hundredRupeeImage);
ImageIcon twoHundredRupeeImage = new ImageIcon("images/currency/200.jpg");
JButton twoHundredRupeeButton = new JButton("", twoHundredRupeeImage);

//You have input:
JLabel moneyInputLabel2 = new JLabel("You have input:");
JTextField moneyInput = new JTextField("₹0.00", 30);

//Enter / return notes
JButton enterCurrency = new JButton("Enter Money");
JButton returnCurrency = new JButton ("Collect Money");
JTextArea outputMessage = new JTextArea(2,30);

//cancel order objects
JLabel cancelOrderLabel = new JLabel("Cancel / Clear Order:");
ImageIcon cancelOrderImage = new ImageIcon("images/cancelOrderImage.jpg");
JButton cancelOrder = new JButton("", cancelOrderImage);

//product stock levels all set at 10 stock per item
JTextField product1stock = new JTextField("10", 2);
JTextField product2stock = new JTextField("10", 2);
JTextField product3stock = new JTextField("10", 2);
JTextField product4stock = new JTextField("10", 2);
JTextField product5stock = new JTextField("10", 2);
JTextField product6stock = new JTextField("10", 2);
JTextField product7stock = new JTextField("10", 2);
JTextField product8stock = new JTextField("10", 2);
JTextField product9stock = new JTextField("10", 2);
JTextField product10stock = new JTextField("10", 2);

//currency stock
JTextField fiveRStock = new JTextField("20", 2);
JTextField tenRStock = new JTextField("20", 2);
JTextField twentyRStock = new JTextField("20", 2);
JTextField fiftyRStock = new JTextField("20", 2);
JTextField hundredRStock = new JTextField("20", 2);
JTextField twoHundredRStock = new JTextField("20", 2);

//take change button
JButton takeChange = new JButton("Collect Change");

//declarations for changeFrame:
ImageIcon cfLabelicon = new ImageIcon("images/CFLabel1icon.jpg");
JLabel cfLabelTakeChange = new JLabel("", cfLabelicon, JLabel.CENTER);

//Money buttons with imageIcons for changeFrame (imageicons used same as previous)
JButton CFfiveRupeeButton = new JButton("", fiveRupeeImage);
JButton CFtenRupeeButton = new JButton("", tenRupeeImage);
JButton CFtwentyRupeeButton = new JButton("", twentyRupeeImage);
JButton CFfiftyRupeeButton = new JButton("", fiftyRupeeImage);
JButton CFhundredRupeeButton = new JButton("", hundredRupeeImage);
JButton CFtwoPoundButton = new JButton("", twoHundredRupeeImage);

//currency stock CF
JTextField CFfiveRStock = new JTextField("20", 2);
JTextField CFtenRStock = new JTextField("20", 2);
JTextField CFtwentyRStock = new JTextField("20", 2);
JTextField CFfiftyRStock = new JTextField("20", 2);
JTextField CFhundredRStock = new JTextField("20", 2);
JTextField CFtwoHundredRStock = new JTextField("20", 2);
JLabel CFpleaseTakeChange = new JLabel("Please select how you would like your change:");
JLabel CFchangeRemainingLabel = new JLabel("Change Remaining: ₹");
JTextField CFchangeRemaining = new JTextField("",10);
JButton CFruleH1 = new JButton("");
JTextArea CFoutputMessage = new JTextArea("", 2, 30);
JButton CFfinished = new JButton("Finished");

//close button
JButton CFclose = new JButton("Close This Window");//will be enabled once correct change has been taken
Connection order;
Statement myStatement;
String writeString = "";
//End declarations of objects
//calculation stuff:
double productTotal = 0;//holds value for total to be inserted (total price of all selected items)
double totalInserted = 0;//holds value for total money put in

//stock number values which are deducted in value as each product is selected:
double product1stockNum = 10;
double product2stockNum = 10;
double product3stockNum = 10;
double product4stockNum = 10;
double product5stockNum = 10;
double product6stockNum = 10;
double product7stockNum = 10;
double product8stockNum = 10;
double product9stockNum = 10;
double product10stockNum = 10;

double fiveRStockNum = 20;
double tenRStockNum = 20;
double twentyRStockNum = 20;
double fiftyRStockNum = 20;
double hundredRStockNum = 20;
double twoHundredRStockNum = 20;
//end calculation stuff.
public static void main(String[] args)
{
    VendingMachine jf = new VendingMachine();
    dh = new FileHandler();//data handler for file writer
}

public VendingMachine()
{
    setLayout(null);//Null layout for absolute positioning
    setSize(900, 750);//Dimensions 900x750
    setTitle("Java Vending Machine");//Title
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    selectLabel.setBounds(10,50,200,15);
    add(selectLabel);
    
    //row 1 of product image buttons
    product1.setBounds(20,75,140,150);
    product1.addActionListener(this);
    add(product1);
    product2.setBounds(180,75,140,150);
    product2.addActionListener(this);
    add(product2);
    product3.setBounds(340,75,140,150);
    product3.addActionListener(this);
    add(product3);
    product4.setBounds(500,75,140,150);
    product4.addActionListener(this);
    add(product4);
    product5.setBounds(660,75,140,150);
    product5.addActionListener(this);
    add(product5);

    //row 2 = row 1 product descriptions and prices
    product1des.setBounds(20,225,140,15);
    add(product1des);
    product1price.setBounds(20,250,140,15);
    product1price.setForeground(Color.red);
    add(product1price);
    product2des.setBounds(180,225,140,15);
    add(product2des);
    product2price.setBounds(180,250,140,15);
    product2price.setForeground(Color.red);
    add(product2price);
    product3des.setBounds(340,225,140,15);
    add(product3des);
    product3price.setBounds(340,250,140,15);
    product3price.setForeground(Color.red);
    add(product3price);
    product4des.setBounds(500,225,140,15);
    add(product4des);
    product4price.setBounds(500,250,140,15);
    product4price.setForeground(Color.red);
    add(product4price);
    product5des.setBounds(660,225,140,15);
    add(product5des);
    product5price.setBounds(660,250,140,15);
    product5price.setForeground(Color.red);
    add(product5price);

    //row 3 = row 2 of product image buttons
    product6.setBounds(20,270,140,150);
    product6.addActionListener(this);
    add(product6);
    product7.setBounds(180,270,140,150);
    product7.addActionListener(this);
    add(product7);
    product8.setBounds(340,270,140,150);
    product8.addActionListener(this);
    add(product8);
    product9.setBounds(500,270,140,150);
    product9.addActionListener(this);
    add(product9);
    product10.setBounds(660,270,140,150);
    product10.addActionListener(this);
    add(product10);

    //row 4 = row 2 of product descriptions and prices
    product6des.setBounds(20,420,140,15);
    add(product6des);
    product6price.setBounds(20,445,140,15);
    product6price.setForeground(Color.red);
    add(product6price);
    product7des.setBounds(180,420,140,15);
    add(product7des);
    product7price.setBounds(180,445,140,15);
    product7price.setForeground(Color.red);
    add(product7price);
    product8des.setBounds(340,420,140,15);
    add(product8des);
    product8price.setBounds(340,445,140,15);
    product8price.setForeground(Color.red);
    add(product8price);
    product9des.setBounds(500,420,150,15);
    add(product9des);
    product9price.setBounds(500,445,150,15);
    product9price.setForeground(Color.red);
    add(product9price);
    product10des.setBounds(660,420,150,15);
    add(product10des);
    product10price.setBounds(660,445,150,15);
    product10price.setForeground(Color.red);
    add(product10price);

    //product stock fields
    product1stock.setBounds(161,75,17,20);
    product1stock.setEditable(false);
    add(product1stock);
    product2stock.setBounds(321,75,17,20);
    product2stock.setEditable(false);
    add(product2stock);
    product3stock.setBounds(481,75,17,20);
    product3stock.setEditable(false);
    add(product3stock);
    product4stock.setBounds(641,75,17,20);
    product4stock.setEditable(false);
    add(product4stock);
    product5stock.setBounds(801,75,17,20);
    product5stock.setEditable(false);
    add(product5stock);
    product6stock.setBounds(161,270,17,20);
    product6stock.setEditable(false);
    add(product6stock);
    product7stock.setBounds(321,270,17,20);
    product7stock.setEditable(false);
    add(product7stock);
    product8stock.setBounds(481,270,17,20);
    product8stock.setEditable(false);
    add(product8stock);
    product9stock.setBounds(641,270,17,20);
    product9stock.setEditable(false);
    add(product9stock);
    product10stock.setBounds(801,270,17,20);
    product10stock.setEditable(false);
    add(product10stock);

    //horizontal rule to seperate products from the lower section
    ruleH.setBounds(15,465,1000,2);
    add(ruleH);

    //Selected products section
    selectedLabel.setBounds(15,475,220,15);
    add(selectedLabel);
    selectedItems.setBounds(15,495,250,145);
    selectedItems.setEditable(false);
    add(selectedItems);

    //total price
    selectedItemTotalLabel.setBounds(15,645,120,20);
    add(selectedItemTotalLabel);
    selectedItemTotal.setBounds(140,645,125,20);
    selectedItemTotal.setEditable(false);
    add(selectedItemTotal);
    //vert rule seperating the selected items from the money section
    ruleV.setBounds(283,475,2,185);
    add(ruleV);
    //money input section:
    //money label:
    moneyInputLabel.setBounds(290,470,150,20);
    add(moneyInputLabel);
    fiveRupeeButton.setBounds(290,495,68,68);
    fiveRupeeButton.addActionListener(this);
    add(fiveRupeeButton);
    tenRupeeButton.setBounds(379,495,68,68);
    tenRupeeButton.addActionListener(this);
    add(tenRupeeButton);
    twentyRupeeButton.setBounds(471,495,68,68);
    twentyRupeeButton.addActionListener(this);
    add(twentyRupeeButton);
    fiftyRupeeButton.setBounds(290,565,68,68);
    fiftyRupeeButton.addActionListener(this);
    add(fiftyRupeeButton);
    hundredRupeeButton.setBounds(379,565,68,68);
    hundredRupeeButton.addActionListener(this);
    add(hundredRupeeButton);
    twoHundredRupeeButton.setBounds(471,565,68,68);
    twoHundredRupeeButton.addActionListener(this);
    add(twoHundredRupeeButton);
    
    //money stock values
    fiveRStock.setBounds(358,495,18,20);
    fiveRStock.setEditable(false);
    add(fiveRStock);
    tenRStock.setBounds(447,495,18,20);
    tenRStock.setEditable(false);
    add(tenRStock);
    twentyRStock.setBounds(539,495,18,20);
    twentyRStock.setEditable(false);
    add(twentyRStock);
    fiftyRStock.setBounds(358,565,18,20);
    fiftyRStock.setEditable(false);
    add(fiftyRStock);
    hundredRStock.setBounds(447,565,18,20);
    hundredRStock.setEditable(false);
    add(hundredRStock);
    twoHundredRStock.setBounds(539,565,18,20);
    twoHundredRStock.setEditable(false);
    add(twoHundredRStock);

    //money input section:
    moneyInputLabel2.setBounds(290,638,100,20);
    add(moneyInputLabel2);
    moneyInput.setBounds(380,638,127,20);
    moneyInput.setEditable(false);
    add(moneyInput);

    //vert rule seperating money section from right side section
    ruleV2.setBounds(560,475,2,185);
    add(ruleV2);
    enterCurrency.setBounds(568,475,250,40);
    enterCurrency.addActionListener(this);
    add(enterCurrency);
    returnCurrency.setBounds(568,525,250,40);
    returnCurrency.addActionListener(this);
    add(returnCurrency);
    outputMessage.setBounds(568,575,250,50);
    outputMessage.setEditable(false);
    add(outputMessage);

    //cancel order
    cancelOrderLabel.setBounds(676,635,122,25);
    add(cancelOrderLabel);
    cancelOrder.setBounds(794,635,25,25);
    cancelOrder.addActionListener(this);
    add(cancelOrder);

    //take change
    takeChange.setBounds(565,635,109,25);
    takeChange.setForeground(Color.red);
    takeChange.setVisible(false);
    takeChange.addActionListener(this);
    add(takeChange);

    try 
    {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String sourceURL = new String ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=VendingMachineDB.mdb;");
        order = DriverManager.getConnection(sourceURL, "admin", "");
        myStatement = order.createStatement();
    }
    catch (ClassNotFoundException cnfe) 
    {
        System.out.println(cnfe);
    }
    catch (SQLException sqle) 
    {
        System.out.println(sqle);
    }
    setVisible(true);//Window is visible
    setResizable(false);
}
//new class for the frame
public void changeFrameInit()
{
    changeFrame.setSize(504, 390);//size of frame
    changeFrame.setLayout(null);//Null layout for absolute positioning
    changeFrame.setVisible(false);
    changeFrame.setResizable(false);
    changeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//disables the "X" button, so users dont close the window before inserting change

    cfLabelTakeChange.setBounds(22,2,450,40);
    changeFrame.add(cfLabelTakeChange);
    CFpleaseTakeChange.setBounds(6,50,300,20);
    changeFrame.add(CFpleaseTakeChange);

    //money
    CFfiveRupeeButton.setBounds(10,80,68,68);
    CFfiveRupeeButton.addActionListener(this);
    changeFrame.add(CFfiveRupeeButton);

    CFtenRupeeButton.setBounds(92,80,68,68);
    CFtenRupeeButton.addActionListener(this);
    changeFrame.add(CFtenRupeeButton);

    CFtwentyRupeeButton.setBounds(174,80,68,68);
    CFtwentyRupeeButton.addActionListener(this);
    changeFrame.add(CFtwentyRupeeButton);

    CFfiftyRupeeButton.setBounds(256,80,68,68);
    CFfiftyRupeeButton.addActionListener(this);
    changeFrame.add(CFfiftyRupeeButton);

    CFhundredRupeeButton.setBounds(338,80,68,68);
    CFhundredRupeeButton.addActionListener(this);
    changeFrame.add(CFhundredRupeeButton);

    CFtwoPoundButton.setBounds(420,80,68,68);
    CFtwoPoundButton.addActionListener(this);
    changeFrame.add(CFtwoPoundButton);

    //stock of currency
    CFfiveRStock.setBounds(35,150,18,20);
    CFfiveRStock.setEditable(false);
    changeFrame.add(CFfiveRStock);

    CFtenRStock.setBounds(117,150,18,20);
    CFtenRStock.setEditable(false);
    changeFrame.add(CFtenRStock);

    CFtwentyRStock.setBounds(199,150,18,20);
    CFtwentyRStock.setEditable(false);
    changeFrame.add(CFtwentyRStock);

    CFfiftyRStock.setBounds(281,150,18,20);
    CFfiftyRStock.setEditable(false);
    changeFrame.add(CFfiftyRStock);

    CFhundredRStock.setBounds(364,150,18,20);
    CFhundredRStock.setEditable(false);
    changeFrame.add(CFhundredRStock);

    CFtwoHundredRStock.setBounds(445,150,18,20);
    CFtwoHundredRStock.setEditable(false);
    changeFrame.add(CFtwoHundredRStock);

    //horizontal rule
    CFruleH1.setBounds(4,180,600,2);
    changeFrame.add(CFruleH1);

    //changeremaining
    CFchangeRemainingLabel.setBounds(6,190,120,20);
    changeFrame.add(CFchangeRemainingLabel);
    CFchangeRemaining.setBounds(125,190,60,20);
    CFchangeRemaining.setEditable(false);
    changeFrame.add(CFchangeRemaining);

    //output
    CFoutputMessage.setBounds(120,220,250,60);
    CFoutputMessage.setEditable(false);
    changeFrame.add(CFoutputMessage);

    //finished btn
    CFfinished.setBounds(192,290,100,20);
    CFfinished.addActionListener(this);
    changeFrame.add(CFfinished);

    //close btn
    CFclose.setBounds(145,320,200,25);
    CFclose.addActionListener(this);
    CFclose.setVisible(false);
    changeFrame.add(CFclose);
}

private void closeChangeFrame()
{
    changeFrame.setVisible(false);
}

public void actionPerformed(ActionEvent e)
{
    //event handling code here
    DecimalFormat poundsFormat = new DecimalFormat ("₹0.00");
    //format for numbers (used for stock levels)
    DecimalFormat numFormat = new DecimalFormat ("0");
    DecimalFormat decFormat = new DecimalFormat("0.00");
    String addToSelection;//adds the selected product to the output section
    double errorGiveChange = totalInserted - productTotal;
    //change Frame actions:
    //product1
    if (e.getSource() == product1)
    {
        //adds product to the database
        writeString ="INSERT INTO VendingMachine(Products, Price) VALUES('Kurkure', '₹20')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n Kurkure - ₹20";
        selectedItems.setText(addToSelection);
        productTotal += 20;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product1stockNum -= 1;
        product1stock.setText(numFormat.format(product1stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product1stockNum == 0)
        {
            product1.setEnabled(false);
            showMessageDialog(null, "Sorry, Kurkure is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //product2
    if (e.getSource() == product2)
    {
        //adds product to the database
        writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('Protein Bar', '₹45')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n Protein Bar - ₹45";
        selectedItems.setText(addToSelection);
        productTotal += 45;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product2stockNum -= 1;
        product2stock.setText(numFormat.format(product2stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product2stockNum == 0)
        {
            product2.setEnabled(false);
            showMessageDialog(null, "Sorry, Protein Bars are currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //product3
    if (e.getSource() == product3)
    {
        //adds product to the database
        writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('Coca Cola', '₹35')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n Coca Cola - ₹35";
        selectedItems.setText(addToSelection);
        productTotal += 35;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product3stockNum -= 1;
        product3stock.setText(numFormat.format(product3stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product3stockNum == 0)
        {
            product3.setEnabled(false);
            showMessageDialog(null, "Sorry, Coca Cola is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //product4
    if (e.getSource() == product4)
    {
        //adds product to the database
        writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('Oreo', '₹10')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n Oreo - ₹10";
        selectedItems.setText(addToSelection);
        productTotal += 10;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product4stockNum -= 1;
        product4stock.setText(numFormat.format(product4stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product4stockNum == 0)
        {
            product4.setEnabled(false);
            showMessageDialog(null, "Sorry, Oreo is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //product5
    if (e.getSource() == product5)
    {
        //adds product to the database
        writeString =
        "INSERT INTO VendingMachine(Products, Price) VALUES('Bisleri', '₹20')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n Bisleri - ₹20";
        selectedItems.setText(addToSelection);
        productTotal += 20;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product5stockNum -= 1;
        product5stock.setText(numFormat.format(product5stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product5stockNum == 0)
        {
            product5.setEnabled(false);
            showMessageDialog(null, "Sorry, Bisleri is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
    //product6
    if (e.getSource() == product6)
    {
        //adds product to the database
        writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('KitKat', '₹20')";
        //adds the text string the the selected items text field
        addToSelection = selectedItems.getText() + "\n KitKat - ₹20";
        selectedItems.setText(addToSelection);
        productTotal += 20;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product6stockNum -= 1;
        product6stock.setText(numFormat.format(product6stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product6stockNum == 0)
        {
            product6.setEnabled(false);
            showMessageDialog(null, "Sorry, KitKat is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
    }
        //product7
        if (e.getSource() == product7)
        {
            //adds product to the database
            writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('DairyMilk Silk', '₹85')";
            addToSelection = selectedItems.getText() + "\n DairyMilk Silk- ₹85";
            selectedItems.setText(addToSelection);
            productTotal += 85;
            selectedItemTotal.setText(poundsFormat.format(productTotal));
            //updates the stock count by deducting 1
            product7stockNum -= 1;
            product7stock.setText(numFormat.format(product7stockNum));
            //if the product stock is 0, disabled the product and brings up an error message
            if (product7stockNum == 0)
            {
                product7.setEnabled(false);
                showMessageDialog(null, "Sorry, Silk is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //product8
        if (e.getSource() == product8)
        {
        //adds product to the database
        writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('Amul Kool', '₹20')";
        addToSelection = selectedItems.getText() + "\n Amul Kool - ₹20";
        selectedItems.setText(addToSelection);
        productTotal += 20;
        selectedItemTotal.setText(poundsFormat.format(productTotal));
        //updates the stock count by deducting 1
        product8stockNum -= 1;
        product8stock.setText(numFormat.format(product8stockNum));
        //if the product stock is 0, disabled the product and brings up an error message
        if (product8stockNum == 0)
        {
            product8.setEnabled(false);
            showMessageDialog(null, "Sorry, Amul Kool is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
        }
        //product9
        if (e.getSource() == product9)
        {
            //adds product to the database
            writeString = "INSERT INTO VendingMachine(Products, Price) VALUES('Appy Fizz', '₹30')";
            //adds the text string the the selected items text field
            addToSelection = selectedItems.getText() + "\n Appy Fizz - ₹30";
            selectedItems.setText(addToSelection);
            productTotal += 30;
            selectedItemTotal.setText(poundsFormat.format(productTotal));
            //updates the stock count by deducting 1
            product9stockNum -= 1;
            product9stock.setText(numFormat.format(product9stockNum));
            //if the product stock is 0, disabled the product and brings up an error message
            if (product9stockNum == 0)
            {
                product9.setEnabled(false);
                showMessageDialog(null, "Sorry, Bisleri is currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //product10
        if (e.getSource() == product10)
        {
            //adds product to the database
            writeString =
            "INSERT INTO VendingMachine(Products, Price) VALUES('Bhujia', '₹10')";
            //adds the text string the the selected items text field
            addToSelection = selectedItems.getText() + "\n Bhujia - ₹10";
            selectedItems.setText(addToSelection);
            productTotal += 10;
            selectedItemTotal.setText(poundsFormat.format(productTotal));
            //updates the stock count by deducting 1
            product10stockNum -= 1;
            product10stock.setText(numFormat.format(product10stockNum));
            //if the product stock is 0, disabled the product and brings up an error message
            if (product10stockNum == 0)
            {
                product10.setEnabled(false);
                showMessageDialog(null, "Sorry, KitKats are currently out of stock", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //cancel order
        if (e.getSource() == cancelOrder)
        {
            selectedItems.setText("");
            moneyInput.setText(poundsFormat.format(productTotal - productTotal));
            selectedItemTotal.setText("₹0.00");
            outputMessage.setText("");
            outputMessage.setBackground(Color.white);
            //gets rid of take change button incase the previous order had change to be given
            takeChange.setVisible(false);
            //reset values
            totalInserted = 0;
            productTotal = 0;
        }
        //enter
        if (e.getSource() == enterCurrency)//if enter notes button is pressed:
        {
            String productsFW = selectedItems.getText();
            String totalFW = selectedItemTotal.getText();
            String inputFW = moneyInput.getText();
            dh.write(productsFW, totalFW, inputFW);
            double changePH = errorGiveChange;
            CFchangeRemaining.setText(decFormat.format(changePH));
            //first check if anything has been input, first money, then products
            //if no money is input at all
            if (totalInserted == 0)
            {
                outputMessage.setText("Error! Please input your money using the \n'Input Money' Section!\n You need to input " + poundsFormat.format(productTotal) + " !");
                outputMessage.setBackground(Color.red);
            }
            //if no product is input
            else if (productTotal == 0)
            {
                outputMessage.setText("Error! Please select at least one product!");
                outputMessage.setBackground(Color.red);
            }
            else if (productTotal == totalInserted)//Correct money is input
            {
                outputMessage.setText(poundsFormat.format(totalInserted) + " Accepted! \n\nThank you for your purchase!");
                outputMessage.setBackground(Color.green);
                //clear all other areas once accepted:
                selectedItems.setText("");
                selectedItemTotal.setText("₹0.00");
                moneyInput.setText("₹0.00");
                //reset values to 0
                totalInserted = 0;
                productTotal = 0;
            }
            else if (totalInserted < productTotal)//Not enough money is input
            {
                //this works out the rest of the input needed:
                double errorInputShort = productTotal - totalInserted;
                //this sum is then applied with pounds format to the output message to tell the user:
                outputMessage.setText("Error! Please input the correct amount!\n\n You still have " + poundsFormat.format(errorInputShort) + " to pay!");
                outputMessage.setBackground(Color.red);
            }
            else if (totalInserted > productTotal)//if too much money is input
            {
                //make the "take change button visible
                takeChange.setVisible(true);
                //disable other buttons, gives focus and is professioanl and eliminates error
                product1.setEnabled(false);
                product2.setEnabled(false);
                product3.setEnabled(false);
                product4.setEnabled(false);
                product5.setEnabled(false);
                product6.setEnabled(false);
                product7.setEnabled(false);
                product8.setEnabled(false);
                product9.setEnabled(false);
                product10.setEnabled(false);
                enterCurrency.setEnabled(false);
                returnCurrency.setEnabled(false);
                cancelOrder.setEnabled(false);
                fiveRupeeButton.setEnabled(false);
                tenRupeeButton.setEnabled(false);
                twentyRupeeButton.setEnabled(false);
                fiftyRupeeButton.setEnabled(false);
                hundredRupeeButton.setEnabled(false);
                twoHundredRupeeButton.setEnabled(false);
                //this is then added to the output message (with pounds format)
                outputMessage.setText(poundsFormat.format(totalInserted) + " Accepted! Thank you for your purchase!\nPlease take your " + poundsFormat.format(errorGiveChange) + " change.\nPress the 'Take Change' button below:");
                outputMessage.setBackground(Color.green);
                //clear textfields
                selectedItems.setText("");
                selectedItemTotal.setText("₹0.00");
                moneyInput.setText("₹0.00");
                //reset values
                totalInserted = 0;
                productTotal = 0;
            }
        }
        //take change button
        if (e.getSource() == takeChange)
        {
            //removes the button as it is clicked, so it cannot be shown again till an order has been made
            takeChange.setVisible(false);
            changeFrameInit();
            changeFrame.setVisible(true);
            //sets the money stock into that of the change frame
            CFfiveRStock.setText(numFormat.format(fiveRStockNum));
            CFtenRStock.setText(numFormat.format(tenRStockNum));
            CFtwentyRStock.setText(numFormat.format(twentyRStockNum));
            CFfiftyRStock.setText(numFormat.format(fiftyRStockNum));
            CFhundredRStock.setText(numFormat.format(hundredRStockNum));
            CFtwoHundredRStock.setText(numFormat.format(twoHundredRStockNum));
        }
        //CF 5p
        if (e.getSource() == CFfiveRupeeButton)
        {
            //deducts one count from the change stock
            fiveRStockNum -=1;
            CFfiveRStock.setText(numFormat.format(fiveRStockNum));
            //deducts amount from the change remaining
            double calcChange = Double.parseDouble(CFchangeRemaining.getText());
            calcChange -=5;
            CFchangeRemaining.setText(decFormat.format(calcChange));
            //if user tries to take too much change
            if (calcChange < 0)
            {
                calcChange +=5; //adds the 1pound back to the value
                CFchangeRemaining.setText(decFormat.format(calcChange));
                //reset the stock value (as if it was never changed)
                fiveRStockNum +=1;
                CFfiveRStock.setText(numFormat.format(fiveRStockNum));
                //set error message
                CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
                CFoutputMessage.setBackground(Color.red);
            }
            if (fiveRStockNum == 0)
            {
                CFfiveRupeeButton.setEnabled(false);
                showMessageDialog(null, "Sorry, there are no ₹5 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == CFtenRupeeButton)
        {
            //deducts one count from the change stock
            tenRStockNum -=1;
            CFtenRStock.setText(numFormat.format(tenRStockNum));
            //deducts amount from the change remaning
            double calcChange = Double.parseDouble(CFchangeRemaining.getText());
            calcChange -=10;
            CFchangeRemaining.setText(decFormat.format(calcChange));
            //if user tries to take too much change
            if (calcChange < 0)
            {
                calcChange +=10; //adds the 1pound back to the value
                CFchangeRemaining.setText(decFormat.format(calcChange));
                //reset the stock value (as if it was never changed)
                tenRStockNum +=1;
                CFtenRStock.setText(numFormat.format(tenRStockNum));
                //set error message
                CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
                CFoutputMessage.setBackground(Color.red);
            }
            if (tenRStockNum == 0)
            {
                CFtenRupeeButton.setEnabled(false);
                showMessageDialog(null, "Sorry, there are no ₹10 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getSource() == CFtwentyRupeeButton)
        {
            //deducts one count from the change stock
            twentyRStockNum -=1;
            CFtwentyRStock.setText(numFormat.format(twentyRStockNum));
            //deducts amount from change remaining
            double calcChange = Double.parseDouble(CFchangeRemaining.getText());
            calcChange -=20;
            CFchangeRemaining.setText(decFormat.format(calcChange));
            //if user tries to take too much change
            if (calcChange < 0)
            {
                calcChange +=020; //adds the 1pound back to the value
                CFchangeRemaining.setText(decFormat.format(calcChange));
                //reset the stock value (as if it was never changed)
                twentyRStockNum +=1;
                CFtwentyRStock.setText(numFormat.format(twentyRStockNum));
                //set error message
                CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
                CFoutputMessage.setBackground(Color.red);
            }
            if (twentyRStockNum == 0)
            {
                CFtwentyRupeeButton.setEnabled(false);
                showMessageDialog(null, "Sorry, there are no ₹20 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
            }
        }
        //CF 50p
        if (e.getSource() == CFfiftyRupeeButton)
        {
        //deducts one count from the change stock
        fiftyRStockNum -=1;
        CFfiftyRStock.setText(numFormat.format(fiftyRStockNum));
        //deducts amount from change remaining
        double calcChange = Double.parseDouble(CFchangeRemaining.getText());
        calcChange -=50;
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //if user tries to take too much change
        if (calcChange < 0)
        {
        calcChange +=50; //adds the 1pound back to the value
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //reset the stock value (as if it was never changed)
        fiftyRStockNum +=1;
        CFfiftyRStock.setText(numFormat.format(fiftyRStockNum));
        //set error message
        CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
        CFoutputMessage.setBackground(Color.red);
        }
        if (fiftyRStockNum == 0)
        {
        CFfiftyRupeeButton.setEnabled(false);
        showMessageDialog(null, "Sorry, there are no ₹50 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
        }
        //CF 1pound
        if (e.getSource()== CFhundredRupeeButton)
        {
        //deducts one count from the change stock
        hundredRStockNum -=1;
        CFhundredRStock.setText(numFormat.format(hundredRStockNum));
        //deducts amount from change remaining
        double calcChange = Double.parseDouble(CFchangeRemaining.getText());
        calcChange -=100;
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //if user tries to take too much change
        if (calcChange < 0)
        {
        calcChange +=100; //adds the 1pound back to the value
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //reset the stock value (as if it was never changed)
        hundredRStockNum +=1;
        CFhundredRStock.setText(numFormat.format(hundredRStockNum));
        //set error message
        CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
        CFoutputMessage.setBackground(Color.red);
        }
        if (hundredRStockNum == 0)
        {
        CFhundredRupeeButton.setEnabled(false);
        showMessageDialog(null, "Sorry, there are no ₹100 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
        }
        //CF 2pound
        if (e.getSource() == CFtwoPoundButton)
        {
        //deducts one count from the change stock
        twoHundredRStockNum -=1;
        CFtwoHundredRStock.setText(numFormat.format(twoHundredRStockNum));
        //deducts amount from change remaining
        double calcChange = Double.parseDouble(CFchangeRemaining.getText());
        
        calcChange -=200;
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //if user tries to take too much change
        if (calcChange < 0)
        {
        calcChange +=200; //adds the 1pound back to the value
        CFchangeRemaining.setText(decFormat.format(calcChange));
        //reset the stock value (as if it was never changed)
        twoHundredRStockNum +=1;
        CFtwoHundredRStock.setText(numFormat.format(twoHundredRStockNum));
        //set error message
        CFoutputMessage.setText(" Error!\nYou cannot take that much!\nYou only have ₹" + decFormat.format(calcChange) + " in change left to take!");
        CFoutputMessage.setBackground(Color.red);
        }
        if (twoHundredRStockNum == 0)
        {
        CFtwoPoundButton.setEnabled(false);
        showMessageDialog(null, "Sorry, there are no ₹200 notes left.\n\nPlease select other notes.", "Stock Depleted!", JOptionPane.WARNING_MESSAGE);
        }
        }
        //CF finished button
        if (e.getSource() == CFfinished)
        {
        //gets value of change remaining
        double calcChange = Double.parseDouble(CFchangeRemaining.getText());
        if (calcChange > 0)
        {
        CFoutputMessage.setText(" Error!\n\nYou still have ₹" + decFormat.format(calcChange) + " in change to take!");
        CFoutputMessage.setBackground(Color.red);
        }
        if (calcChange == 0)
        {
        CFoutputMessage.setText(" Thank You!\nPlease press the button below to close\nthis window.");
        CFoutputMessage.setBackground(Color.green);
        //enables the close button visible
        CFclose.setVisible(true);
        //disables all other buttons on the frame, adds focus, gives user indication of what to do next
        CFfiveRupeeButton.setEnabled(false);
        CFtenRupeeButton.setEnabled(false);
        CFtwentyRupeeButton.setEnabled(false);
        CFfiftyRupeeButton.setEnabled(false);
        CFhundredRupeeButton.setEnabled(false);
        
        CFtwoPoundButton.setEnabled(false);
        CFfinished.setEnabled(false);
        }
        }
        //change frame close button
        if (e.getSource() == CFclose)
        {
        //calls function close change frame
        closeChangeFrame();
        //re-enable all buttons on main frame
        product1.setEnabled(true);
        product2.setEnabled(true);
        product3.setEnabled(true);
        product4.setEnabled(true);
        product5.setEnabled(true);
        product6.setEnabled(true);
        product7.setEnabled(true);
        product8.setEnabled(true);
        product9.setEnabled(true);
        product10.setEnabled(true);
        enterCurrency.setEnabled(true);
        returnCurrency.setEnabled(true);
        cancelOrder.setEnabled(true);
        fiveRupeeButton.setEnabled(true);
        tenRupeeButton.setEnabled(true);
        twentyRupeeButton.setEnabled(true);
        fiftyRupeeButton.setEnabled(true);
        hundredRupeeButton.setEnabled(true);
        twoHundredRupeeButton.setEnabled(true);
        CFfiveRupeeButton.setEnabled(true);
        CFtenRupeeButton.setEnabled(true);
        CFtwentyRupeeButton.setEnabled(true);
        CFfiftyRupeeButton.setEnabled(true);
        CFhundredRupeeButton.setEnabled(true);
        CFtwoPoundButton.setEnabled(true);
        CFfinished.setEnabled(true);
        //reset the output message on main frame
        outputMessage.setText("");
        outputMessage.setBackground(Color.white);
        }
        //return
        if (e.getSource() == returnCurrency)
        {
        if (totalInserted == 0)//if no money has been input
        {
        outputMessage.setText("You have not input any money!\n\nPlease try again!");
        outputMessage.setBackground(Color.red);
        //clear money input
        moneyInput.setText("₹0.00");
        //no need to reset value to zero as nothing has been put in
        }
        
        else//if something HAS been input
        {
            outputMessage.setText(poundsFormat.format(totalInserted) + " Returned. \n\nPlease take your money.");
            outputMessage.setBackground(Color.red);
            //clear money input
            moneyInput.setText("₹0.00");
            //reset money input value
            totalInserted = 0;
        }
    }

    //moneyInput Section
    if(e.getSource() == fiveRupeeButton)
    {
        //updates the total input value
        totalInserted += 5;
        moneyInput.setText(poundsFormat.format(totalInserted));
        //updates the stock count by deducting 1
        fiveRStockNum += 1;
        fiveRStock.setText(numFormat.format(fiveRStockNum));
    }
    if(e.getSource() == tenRupeeButton)
    {
        //updates the total input value
        totalInserted += 10;
        moneyInput.setText(poundsFormat.format(totalInserted));
        //updates the stock count by deducting 1
        tenRStockNum += 1;
        tenRStock.setText(numFormat.format(tenRStockNum));
    }
    if(e.getSource() == twentyRupeeButton)
    {
        //updates the total input value
        totalInserted += 20;
        moneyInput.setText(poundsFormat.format(totalInserted));
        twentyRStockNum += 1;
        twentyRStock.setText(numFormat.format(twentyRStockNum));
    }
    if(e.getSource() == fiftyRupeeButton)
    {
        //updates the total input value
        totalInserted += 50;
        moneyInput.setText(poundsFormat.format(totalInserted));
        //updates the stock count by deducting 1
        fiftyRStockNum += 1;
        fiftyRStock.setText(numFormat.format(fiftyRStockNum));
    }
    if(e.getSource() == hundredRupeeButton)
    {
        //updates the total input value
        totalInserted += 100;
        moneyInput.setText(poundsFormat.format(totalInserted));
        //updates the stock count by deducting 1
        hundredRStockNum += 1;
        hundredRStock.setText(numFormat.format(hundredRStockNum));
    }
    if(e.getSource() == twoHundredRupeeButton)
    {
        //updates the total input value
        totalInserted += 200;
        moneyInput.setText(poundsFormat.format(totalInserted));
        //updates the stock count by adding 1
        twoHundredRStockNum += 1;
        twoHundredRStock.setText(numFormat.format(twoHundredRStockNum));
        }
    try 
    {
        myStatement.executeUpdate(writeString);
    }
    catch (SQLException sqle) 
    {
        System.out.println(sqle);
    }
    }
}