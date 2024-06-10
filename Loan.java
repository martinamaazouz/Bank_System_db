public class Loan {   
    private Integer loanNo;
    private String loanType;
    private double loanAmount;
    private Integer customerSSN;
    private String employeeSSN;
    private String status;
    
    

    public Loan(Integer loanNo, String loanType, double loanAmount,Integer customerSSN,String employeeSSN,String status) {
        this.loanNo = loanNo ;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.customerSSN = customerSSN;
        this.employeeSSN = employeeSSN;
        this.status = status;
    }

    public int getLoansNumber() {
        return loanNo;
    }
    
    public String getstatus() {
        return this.status;
    }
        
    public void setstatus(string stat) {
        this.status = stat;
    }
    public void setLoansNumber(Integer loanNo) {
        this.loanNo = loanNo;
    }

    public String getLoansType() {
        return loanType;
    }

    public void setLoansType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setCustomerSSN(Integer customerSSN) {
        this.customerSSN = customerSSN;
    }

    public Integer getCustomerSSN() {
        return customerSSN;
    }
    

    public String toString() {
        // return loanType;
        return "TYPE: " +  loanType + "\n";
    }





}


