/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListOrmweek10Data {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Employee...");
		ormweek10.Employee[] ormweek10Employees = ormweek10.Employee.listEmployeeByQuery(null, null);
		int length = Math.min(ormweek10Employees.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(ormweek10Employees[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Employee by Criteria...");
		ormweek10.EmployeeCriteria lormweek10EmployeeCriteria = new ormweek10.EmployeeCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//lormweek10EmployeeCriteria.id.eq();
		lormweek10EmployeeCriteria.setMaxResults(ROW_COUNT);
		ormweek10.Employee[] ormweek10Employees = lormweek10EmployeeCriteria.listEmployee();
		int length =ormweek10Employees== null ? 0 : Math.min(ormweek10Employees.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(ormweek10Employees[i]);
		}
		System.out.println(length + " Employee record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListOrmweek10Data listOrmweek10Data = new ListOrmweek10Data();
			try {
				listOrmweek10Data.listTestData();
				//listOrmweek10Data.listByCriteria();
			}
			finally {
				ormweek10.Ormweek10PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
