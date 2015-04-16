/**
 * Licensee: Institute of Technology Tallaght
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteOrmweek10Data {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = ormweek10.Ormweek10PersistentManager.instance().getSession().beginTransaction();
		try {
			ormweek10.Employee lormweek10Employee = ormweek10.Employee.loadEmployeeByQuery("id="248", null);
			

			lormweek10Employee.delete();
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteOrmweek10Data deleteOrmweek10Data = new DeleteOrmweek10Data();
			try {
				deleteOrmweek10Data.deleteTestData();
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
