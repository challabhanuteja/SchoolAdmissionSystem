package schoolAdmissionsSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student
{
	private int idno;
	private String name;
	private double grade;
	private double fees=0,totalfee=0;
	private double scholarship=0,concession=0;
	public Student(int idno, String name, double grade,double totalfee) {
		this.idno = idno;
		this.name = name;
		this.grade = grade;
		this.totalfee=totalfee;
	}
	public double getScholarship() {
		return scholarship;
	}
	public void setScholarship(double scholarship) {
		this.scholarship = scholarship;
	}
	public double getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}
	public double getConcession() {
		return concession;
	}
	public void setConcession(double concession) {
		this.concession = concession;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees += fees;
	}
	public int getIdno() {
		return idno;
	}
	public void setIdno(int idno) {
		this.idno = idno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
}
public class School {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Student> a=new ArrayList<>();
		int idno;
		String name;
		double grade,totalfee;
		double scholarship=0,concession=0;
		int c;
		System.out.println("MENU:\n1)To join a new student\n"
				+ "2)To enter fees paid\n"
				+ "3)To get List of outstanding fee payments\n"
				+ "4)To List fee payments made by each student\n"
				+ "5)To enter concessions\n"
				+ "6)To enter schollarship\n"
				+ "7)Modify concessions\n"
				+ "8)Modify scholarship\n"
				+ "9)Display concessions\n"
				+ "10)Display scholarships\n"
				+ "11)Display the list of students yet to pay the fee\n"
				+ "12)List fee stucture of each student\n"
				+ "13)To Exit");
		while(true)
		{
			
			System.out.print("Enter ur choice:");
			c=sc.nextInt();
		switch(c)
		{
		case 1: 
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			System.out.println("Enter student name:");
			name=sc.next();
			System.out.println("Enter student garde:");
			grade=sc.nextDouble();
			System.out.println("Enter student's total fee to be paid:");
			totalfee=sc.nextDouble();
			
			Student s=new Student(idno,name,grade,totalfee);
			a.add(s);
			break;
		case 2:
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			for(Student i:a)
			{
				if(i.getIdno()==idno)
				{
					System.out.println("Enter current payment:");
					i.setFees(sc.nextDouble());
				}
			}
			break;
		case 3:
			System.out.println("Outstanding payments:");
			for(Student i:a)
			{
				if(i.getFees()==0)
				{
					System.out.println(i.getIdno()+" "+i.getName());
				}
			}
			break;
		case 4:
			System.out.println("Payments made till now:");
			System.out.println("Idno\tName\t\tFeesPaid");
			for(Student i:a)
			{
				
				
					System.out.println(i.getIdno()+"\t"+i.getName()+"\t"+"\t"+i.getFees());
				
			}
			break;
		case 5:
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			for(Student i:a)
			{
				if(i.getIdno()==idno)
				{
					System.out.println("Enter concession:");
					concession=sc.nextDouble();
					i.setConcession(concession);
					i.setTotalfee(i.getTotalfee()-concession);
				}
			}
			break;
		case 6:
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			for(Student i:a)
			{
				if(i.getIdno()==idno)
				{
					System.out.println("Enter schollarship:");
					scholarship=sc.nextDouble();
					i.setScholarship(scholarship);
				}
			}
			break;
		case 7:
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			for(Student i:a)
			{
				if(i.getIdno()==idno)
				{
					int temp;
					System.out.print("Enter 1 to delete concession or 2 to modify concession:");
					temp=sc.nextInt();
					if(temp==1)
					{
						i.setTotalfee(i.getConcession()+i.getTotalfee());
						i.setConcession(0);
					}
					else
					{
						System.out.println("Enter new concession:");
						concession=sc.nextDouble();
						i.setConcession(concession);
					}
				}
			}
			break;
		case 8:
			System.out.println("Enter student idno:");
			idno=sc.nextInt();
			for(Student i:a)
			{
				if(i.getIdno()==idno)
				{
					int temp;
					System.out.print("Enter 1 to delete scholarship or 2 to modify scholarship:");
					temp=sc.nextInt();
					if(temp==1)
					{
						
						i.setScholarship(0);;
					}
					else
					{
						System.out.println("Enter new scholarship:");
						scholarship=sc.nextDouble();
						i.setScholarship(scholarship);
					}
				}
			}
			break;
		case 9:
			
			System.out.println("Concessions of all students:");
			System.out.println("Idno\tName\t\tConcession");
			for(Student i:a)
			{
				System.out.println(i.getIdno()+"\t"+i.getName()+"\t"+"\t"+i.getConcession());
			}
			break;
		case 10:
			System.out.println("Scholarships of all students:");
			System.out.println("Idno\tName\t\tScholarship");
			for(Student i:a)
			{
				System.out.println(i.getIdno()+"\t"+i.getName()+"\t"+"\t"+i.getScholarship());
			}
			break;
		case 11:
			
			System.out.println("Students yet to pay the fee:");
			System.out.println("Idno\tName");
			for(Student i:a)
			{	if(i.getFees()<i.getTotalfee())
				System.out.println(i.getIdno()+"\t"+i.getName());
			}
			break;
		case 12:
			
			System.out.println("Fees structure of all students:");
			System.out.println("Idno\tName\t\tFee");
			for(Student i:a)
			{	
				System.out.println(i.getIdno()+"\t"+i.getName()+"\t"+"\t"+i.getTotalfee());
			}
			break;
		case 13:
			sc.close();
			System.exit(0);
		
		}	
		}
	}

}
