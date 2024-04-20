package app.hibernateMain;

import app.tables.Clients;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateMethods {
    public static void addRow(String adress, String order, String employee, String name, String orderDate, String phone) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Clients clients = new Clients(adress, order, employee, name, orderDate, phone);

            session.getTransaction();
            session.persist(clients);
            session.beginTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Clients> getClientsList() {
        ObservableList<Clients> resultList = null;
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            resultList = FXCollections.observableArrayList();

            List<Clients> list = session.createQuery("from Clients", Clients.class).list();
            for (int i = 0; i < list.size(); i++) {
                resultList.add(list.get(i));
                System.out.println(resultList.get(i));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static void updateClients(String oldName, String newName, String newAdress, String newOrder, String newEmployee, String newOrderDate, String newPhone) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Query q = session.createQuery("update Clients " +
                    "set name = :newName, " +
                    "adress = :newAdress, " +
                    "order = :newOrder, " +
                    "employee = :newEmployee, " +
                    "orderDate = :newOrderDate, " +
                    "phone = :newPhone " +
                    "where name = :oldName");

            q.setParameter("oldName", oldName);
            q.setParameter("newName", newName);
            q.setParameter("newAdress", newAdress);
            q.setParameter("newOrder", newOrder);
            q.setParameter("newEmployee", newEmployee);
            q.setParameter("newOrderDate", newOrderDate);
            q.setParameter("newPhone", newPhone);
            q.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteClients(String newName) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            Query q = session.createQuery("delete from Clients where name = :newName");

            q.setParameter("newName", newName);
            q.executeUpdate();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
