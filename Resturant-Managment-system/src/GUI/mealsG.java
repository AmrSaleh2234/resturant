package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import resturantmanagement.Meals;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;  


public class mealsG extends JPanel { // start of the class
	buttoncustom add, delete, update, list, search, addTheMeal, deleteTheMeal, updateTheMeal, searchForMeal, discount, addDiscount; // declaring buttons
	labelcustom title; // declaring labels
	JTextField name, price, newPrice, nameForSearch, discount_text; // declaring text field
	JComboBox<String> meals; // declaring the combo box
	Meals meal = new Meals(); // object from Meals class
	Object col[] = {"Meal Name", "Price", "Discount"}; // declaring the column of the table
	DefaultTableModel tablemodel = new DefaultTableModel(col, 0); // make the table model
	JTable listMeals; // declaring the table
	ArrayList<Meals> mealsForTabel = new ArrayList<Meals>(); // array list for the meals to be used in the table
	JTableHeader headerTable; // declaring the table header
	JScrollPane sp;
	
                   
		
	
	public mealsG() { 
		// setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(650, 500); // set the size of the frame
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to make the frame terminate
		//this.setLocationRelativeTo(null); // to make the frame position in the center
		
		/* create the buttons in the left side of the frame */
		/*=========================================*/
		add = new buttoncustom("Add Meal");
		delete = new buttoncustom("Delete Meal");
		update = new buttoncustom("Update Meal");
		list = new buttoncustom("List Meals");
		search = new buttoncustom("Search For Meal");
                discount = new buttoncustom("Add Discount");
		add.setBounds(30, 100, 150, 30);
		delete.setBounds(30, 150, 150, 30);
		update.setBounds(30, 200, 150, 30);
		list.setBounds(30, 250, 150, 30);
		search.setBounds(30, 300, 150, 30);
                discount.setBounds(30, 350, 150, 30);
		add(add);
		add(delete);
		add(update);
		add(list);
		add(search);
                add(discount);
		
		// adding action to the add button to show the add meal section
		add.addActionListener(new ActionListener() { // start the add button action
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setVisible(true);
				price.setVisible(true);
				addTheMeal.setVisible(true);
				
				//sp.setVisible(false);
				nameForSearch.setVisible(false);
				searchForMeal.setVisible(false);
				headerTable.setVisible(false);
				listMeals.setVisible(false);
				newPrice.setVisible(false);
				updateTheMeal.setVisible(false);
				meals.setVisible(false);
				deleteTheMeal.setVisible(false);
                                discount_text.setVisible(false);
                                addDiscount.setVisible(false);
			}
			
		}); // start the add button action
		
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				meals.setVisible(true);
				deleteTheMeal.setVisible(true);
				
				//sp.setVisible(false);
				nameForSearch.setVisible(false);
				searchForMeal.setVisible(false);
				headerTable.setVisible(false);
				listMeals.setVisible(false);
				newPrice.setVisible(false);
				updateTheMeal.setVisible(false);
				name.setVisible(false);
				price.setVisible(false);
				addTheMeal.setVisible(false);
                                discount_text.setVisible(false);
                                addDiscount.setVisible(false);
			}
			
		});
		
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				meals.setVisible(true);
				newPrice.setVisible(true);
				updateTheMeal.setVisible(true);
				
				//sp.setVisible(false);
				nameForSearch.setVisible(false);
				searchForMeal.setVisible(false);
				headerTable.setVisible(false);
				listMeals.setVisible(false);
				name.setVisible(false);
				price.setVisible(false);
				addTheMeal.setVisible(false);
				deleteTheMeal.setVisible(false);
                                discount_text.setVisible(false);
                                addDiscount.setVisible(false);
			}
		});
		
		list.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listMeals.setVisible(true);
				headerTable.setVisible(true);
				//sp.setVisible(true);
				
				nameForSearch.setVisible(false);
				searchForMeal.setVisible(false);
				meals.setVisible(false);
				newPrice.setVisible(false);
				updateTheMeal.setVisible(false);
				name.setVisible(false);
				price.setVisible(false);
				addTheMeal.setVisible(false);
				deleteTheMeal.setVisible(false);
                                discount_text.setVisible(false);
                                addDiscount.setVisible(false);
			}
		});
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameForSearch.setVisible(true);
				searchForMeal.setVisible(true);
				
				//sp.setVisible(false);
				listMeals.setVisible(false);
				headerTable.setVisible(false);
				meals.setVisible(false);
				newPrice.setVisible(false);
				updateTheMeal.setVisible(false);
				name.setVisible(false);
				price.setVisible(false);
				addTheMeal.setVisible(false);
				deleteTheMeal.setVisible(false);
                                discount_text.setVisible(false);
                                addDiscount.setVisible(false);
			}
		});
                
                discount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        meals.setVisible(true);
                        discount_text.setVisible(true);
                        addDiscount.setVisible(true);
                        
                        nameForSearch.setVisible(false);
                        searchForMeal.setVisible(false);
                        newPrice.setVisible(false);
                        updateTheMeal.setVisible(false);
                        name.setVisible(false);
                        price.setVisible(false);
                        addTheMeal.setVisible(false);
                        deleteTheMeal.setVisible(false);
                        listMeals.setVisible(false);
                        headerTable.setVisible(false);
                    }
                });
		
		/*=========================================*/
		
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
		
		/* create the add meal section */
		/*=========================================*/
		name = new JTextField("name of the meal", 20);
		price = new JTextField("price of the meal", 20);
		addTheMeal = new buttoncustom("Add The Meal");
		name.setBounds(300, 100, 150, 30);
		price.setBounds(300, 150, 150, 30);
		addTheMeal.setBounds(300, 200, 150, 30);
		/*  start adding focus listener for input fields to when the under focus the text will disappear */
		name.addFocusListener(new FocusListener() { // start focus listener
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				name.setText("");
				
			}
		}); // end focus listener
		
		price.addFocusListener(new FocusListener() { // start focus listener
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				price.setText("");
				
			}
		}); // end focus listener
		/*  start adding focus listener for input fields to when the under focus the text will disappear */
		
		// adding action to the button (addTheMeal) to get the information form text field and it to the file
		addTheMeal.addActionListener(new ActionListener() { // start of the action
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String mealName = null;
				double mealPrice = 0;
				try {
					mealName = name.getText();
					mealPrice = Double.parseDouble(price.getText());
					if (mealName.equals("") || mealPrice == 0 || mealName.matches("^[1-9]*$")) {
						JOptionPane.showMessageDialog(null,"There is Something Wrong!!", "Error Message", JOptionPane.ERROR_MESSAGE);  
					} else {
						Meals addMeal = new Meals(mealName, mealPrice);
						addMeal.add();
						JOptionPane.showMessageDialog(null,"Meal added Succefully");  
						meals.addItem(mealName);
                                                String dis = "0.0 %";
						Object[] rowData = {mealName, mealPrice, dis};
						tablemodel.addRow(rowData);
						name.setText("");
						price.setText("");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"There is Something Wrong!!", "Error Message", JOptionPane.ERROR_MESSAGE);  
				}
				
				
			}
			
		}); // end of the action 
		add(name);
		add(price);
		add(addTheMeal);
		name.setVisible(false);
		price.setVisible(false);
		addTheMeal.setVisible(false);
		
		
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
		
		/* create the delete meal section */
		/*=========================================*/
		ArrayList<Meals> m = (ArrayList<Meals>)(Object)meal.list();
                String []s=new String[m.size()];
                for(int i=0;i<m.size();i++)
                {
                    s[i]=m.get(i).get_Product_Name();
                            
                }
		meals = new JComboBox<String>(s);
		deleteTheMeal = new buttoncustom("Delete The Meal");
		meals.setBounds(300, 100, 150, 30);
		deleteTheMeal.setBounds(300, 150, 150, 30);
		
		
		deleteTheMeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (meal.delete((String)meals.getSelectedItem())) {
					JOptionPane.showMessageDialog(null,"Meal Deleted Succefully");
					for (int i=0;i<listMeals.getRowCount();i++) {
						if (tablemodel.getValueAt(i, 0).equals(meals.getSelectedItem())) {
							tablemodel.removeRow(i);
							meals.removeItemAt(meals.getSelectedIndex());
							//(DefaultTableModel)listMeals.getModel()).removeRow(i); 
							break;
						}
					}
                                        
					
				} else {
					JOptionPane.showMessageDialog(null,"There is Something Wrong Has Happend!!", "Error Message", JOptionPane.ERROR_MESSAGE);  
				}
				
			}
			
		});
		
		
		add(meals);
		add(deleteTheMeal);
		meals.setVisible(false);
		deleteTheMeal.setVisible(false);
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
		
		/* create the update meal section */
		/*=========================================*/
		// ====>NOTE: we will use the combo box that in the delete section
		newPrice = new JTextField("Enter The New Price");
		updateTheMeal = new buttoncustom("Update");
		newPrice.setBounds(300, 150, 150, 30);
		updateTheMeal.setBounds(300, 200, 150, 30);
		/*  start adding focus listener for input fields to when the under focus the text will disappear */
		newPrice.addFocusListener(new FocusListener() { // start focus listener
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				newPrice.setText("");
				
			}
		}); // end focus listener
		/*  end adding focus listener for input fields to when the under focus the text will disappear */
		
		updateTheMeal.addActionListener(new ActionListener() { // add action to the update button
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double newPriceNum = Double.parseDouble(newPrice.getText());
					Meals updateMeal = new Meals((String)meals.getSelectedItem(), newPriceNum);
					updateMeal.update();
                                        String dis = null;
					newPrice.setText("");
                                        for (int i=0;i<listMeals.getRowCount();i++) {
						if (tablemodel.getValueAt(i, 0).equals(meals.getSelectedItem())) {
                                                        dis = (String)tablemodel.getValueAt(i, 2);
							tablemodel.removeRow(i);
							//(DefaultTableModel)listMeals.getModel()).removeRow(i); 
							break;
						}
					}
                                        Object[] rowData = {(String)meals.getSelectedItem(), newPriceNum, dis};
                                        tablemodel.addRow(rowData);
                                        
                                        
                                        
					JOptionPane.showMessageDialog(null,"Meal Updated Succefully");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"There is Something Wrong Has Happend!!", "Error Message", JOptionPane.ERROR_MESSAGE);  
				}
				
			}
		}); // end of the action
		
		add(newPrice);
		add(updateTheMeal);
		newPrice.setVisible(false);
		updateTheMeal.setVisible(false);
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
		
		/* create the list meal section */
		/*=========================================*/
		listMeals = new JTable(tablemodel);
		mealsForTabel = (ArrayList<Meals>)(Object)meal.list();
		headerTable = listMeals.getTableHeader();
		//sp = new JScrollPane(listMeals); // scroll    
		headerTable.setBounds(300, 100, 300, 20);
                listMeals.setBounds(300, 120, 300, 200);
		for (int i=0;i<mealsForTabel.size();i++) {
			String mealName = mealsForTabel.get(i).get_Product_Name();
			double mealPrice = mealsForTabel.get(i).getCost();
                        String theDiscount = (mealsForTabel.get(i).getOffer()) * 100 + "%" ;
			Object[] rowData = {mealName, mealPrice, theDiscount};
			tablemodel.addRow(rowData);
		}
		add(headerTable);
		add(listMeals);
	    //sp.setVisible(false);
		headerTable.setVisible(false);
		listMeals.setVisible(false);
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
		
		/* create the Search meal section */
		/*=========================================*/
		nameForSearch = new JTextField("Enter The Name Of The Meal");
		searchForMeal = new buttoncustom("Search");
		nameForSearch.setBounds(300, 100, 150, 30);
		searchForMeal.setBounds(300, 150, 150, 30);
		/*  start adding focus listener for input fields to when the under focus the text will disappear */
		nameForSearch.addFocusListener(new FocusListener() { // start focus listener
			
			@Override
			public void focusLost(FocusEvent e) {}
			
			@Override
			public void focusGained(FocusEvent e) {
				nameForSearch.setText("");
				
			}
		}); // end focus listener
		
		searchForMeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Meals searchMeal = new Meals();
				searchMeal = (Meals)searchMeal.search(nameForSearch.getText());
				if (searchMeal.getCost() != 0) {
					JOptionPane.showMessageDialog(null,"The Name: " + nameForSearch.getText() + "\nThe Price: " + searchMeal.getCost());
				} else {
					JOptionPane.showMessageDialog(null,"The Meal Not Found!!", "Error Message", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		
		add(nameForSearch);
		add(searchForMeal);
		nameForSearch.setVisible(false);
		searchForMeal.setVisible(false);
		/*=========================================*/
		/*=========================================*/
		/*=========================================*/
                
                /* create the add discount in meal section */
		/*=========================================*/
		// ====>NOTE: we will use the combo box that in the delete section
                discount_text = new JTextField();
                addDiscount = new buttoncustom("Add The Discount");
                discount_text.setBounds(300, 150, 150, 30);
                //meals.setBounds(300, 100, 150, 30);
                addDiscount.setBounds(300, 200, 150, 30);
                
                add(discount_text);
                add(addDiscount);
                discount_text.setVisible(false);
                addDiscount.setVisible(false);
                addDiscount.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Meals addDiscount = new Meals();
                        double theDiscount = 0;
                        try {
                            theDiscount = Double.parseDouble(discount_text.getText());
                            addDiscount.makeOffer((String)meals.getSelectedItem(), theDiscount);
                            JOptionPane.showMessageDialog(null,"Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE); 
                            discount_text.setText("");
                            double p = 0;
                            for (int i=0;i<listMeals.getRowCount();i++) {
                                    if (tablemodel.getValueAt(i, 0).equals(meals.getSelectedItem())) {
                                            p = (Double)tablemodel.getValueAt(i, 1);
                                            tablemodel.removeRow(i);
                                            //(DefaultTableModel)listMeals.getModel()).removeRow(i); 
                                            break;
                                    }
                            }
                            String dis = theDiscount * 100 + "%";
                            Object[] rowData = {(String)meals.getSelectedItem(), p, dis};
                            tablemodel.addRow(rowData);
                        } catch(Exception e1) {
                            JOptionPane.showMessageDialog(null,"There is error\nthe discount haven't been added", "Error Message", JOptionPane.ERROR_MESSAGE); 
                        }
                    }
                });
		
		setLayout(null);
		
		this.setVisible(true);
		
	} // end of constructor
} // end of the class
