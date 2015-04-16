/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateOrmweek10Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = ormweek10.Ormweek10PersistentManager.instance().getSession().beginTransaction();
		try {
			ormweek10.Employee lormweek10Employee = ormweek10.Employee.loadEmployeeByQuery("id = 247", null);
			// Update the properties of the persistent object
			lormweek10Employee.setName("Mr Edit");
			lormweek10Employee.save();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Employee by EmployeeCriteria");
		ormweek10.EmployeeCriteria lormweek10EmployeeCriteria = new ormweek10.EmployeeCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormweek10EmployeeCriteria.id.eq();
		System.out.println(lormweek10EmployeeCriteria.uniqueEmployee());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateOrmweek10Data retrieveAndUpdateOrmweek10Data = new RetrieveAndUpdateOrmweek10Data();
			try {
				retrieveAndUpdateOrmweek10Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateOrmweek10Data.retrieveByCriteria();
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
