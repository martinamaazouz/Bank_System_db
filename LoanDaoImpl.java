package org.example.banksystem.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LoanDaoImpl implements LoanDao {

    private Loan loan;

    @Override
    public void addloan() {
                Scanner scanner = new Scanner(System.in);
                
                try {
                    System.out.print("Enter loan number: ");
                    this.setLoansNumber(scanner.nextLine());

                    System.out.print("Enter your type: ");
                    this.setLoansType(scanner.nextLine());
                    
                    System.out.print("Enter amount: ");
                    this.setLoanAmount(scanner.nextLine());

                    System.out.print("Enter Customer SSN ");
                    this.setCustomerSSN(scanner.nextLine());

                    String query = "insert into loan (loanNo, loanType, loanAmount , customerSSN, employeeSSN, status ) values (? , ? , ? , ? , ? , ?) ";

                    try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                        preparedStatement.setString(1, loanNo);
                        preparedStatement.setString(2, loanType);
                        preparedStatement.setString(3, loanAmount);
                        preparedStatement.setString(4, customerSSN);
                        preparedStatement.setString(5, employeeSSN);
                        preparedStatement.setString(5, "pending");

                        preparedStatement.executeUpdate();
                        System.out.println("loan added !");
                
                
                    } catch (SQLException se) {
                        se.printStackTrace();
                
                    } finally {
                        try {
                            con.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                catch (Exception e) {
                    System.out.println("Error occurred: " + e.getMessage());
                }
                finally {
                    scanner.close();
                }
            }


            
    @Override
    public List<Loan> findAllLoans() {
        Connection con = DBconnection.getConnection();
        if (con == null) {
            return null;
        }
        List<Loan> loans = new LinkedList<>();
        String query ="SELECT Customer.name and loan.id from loan and customer where customer.ssn == loan.ssn ;";
        try (PreparedStatement preparedStatement=con.prepareStatement(query)){
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                 loans.add(loan);
            }
            }catch (SQLException se){
             se.printStackTrace();
            } finally{
            try{
                 con.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
         }
         return employees;
    }

    public void request(){
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter loan type: ");
        // String loanType = input.next();
        // System.out.print("Enter loan amout: ");
        // int amout = input.next();
        addloan();
    }

    public void ResponseLoan(){
        Loan loan;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer id: ");
        String customerId = scanner.nextInt();
        // String query ="SELECT * from loan  where customer.ssn == ? ";
        Connection con = DBconnection.getConnection();
        // try (PreparedStatement preparedStatement=con.prepareStatement(query)){
        //     preparedStatement.setArray(1, customerId);
        //     ResultSet resultSet=preparedStatement.executeQuery();
        //     loan = new Loan(resultSet.getInt("loanNo")
        //     ,resultSet.getString("loanType")
        //     ,resultSet.getDouble("loanAmount")
        //     ,resultSet.getInt("customerSSN")
        //     ,resultSet.getString("employeeSSN"),resultSet.getString("status"));
            

        //  }catch (SQLException e){
        //     System.out.println(e);
        //  }
         String sqlUpdate = "Update Loan SET status = ? Where customer.ssn = ?";
         try (PreparedStatement preparedStatement=con.prepareStatement(query)){
            prepareStatement.setString(1 , "Accepted");
            preparedStatement.setArray(2, customerId);
            preparedStatement.executeUpdate();

         }catch (SQLException e){
            System.out.println(e);
         }

    }
    public void RejectLoan(){
        Loan loan;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer id: ");
        String customerId = scanner.nextInt();
        // String query ="SELECT * from loan  where customer.ssn == ? ";
        Connection con = DBconnection.getConnection();
        // try (PreparedStatement preparedStatement=con.prepareStatement(query)){
        //     preparedStatement.setArray(1, customerId);
        //     ResultSet resultSet=preparedStatement.executeQuery();
        //     loan = new Loan(resultSet.getInt("loanNo")
        //     ,resultSet.getString("loanType")
        //     ,resultSet.getDouble("loanAmount")
        //     ,resultSet.getInt("customerSSN")
        //     ,resultSet.getString("employeeSSN"),resultSet.getString("status"));
            

        //  }catch (SQLException e){
        //     System.out.println(e);
        //  }
         String sqlUpdate = "Update Loan SET status = ? Where customer.ssn = ?";
         try (PreparedStatement preparedStatement=con.prepareStatement(query)){
            prepareStatement.setString(1 , "Rejected");
            preparedStatement.setArray(2, customerId);
            preparedStatement.executeUpdate();

         }catch (SQLException e){
            System.out.println(e);
         }

    }

}
