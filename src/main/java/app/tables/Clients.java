package app.tables;

import jakarta.persistence.*;

@Entity
@Table
public class Clients {

    @Id
    @Column(name = "id")
    private int clientId;

    @Column(name = "adress")
    private String adress;

    @Column(name = "corder")
    private String order;

    @Column(name = "employee")
    private String employee;

    @Column(name = "name")
    private String name;

    @Column(name = "orderDate")
    private String orderDate;

    @Column(name = "phone")
    private String phone;

    public Clients() {
    }

    public Clients(String adress, String order, String employee, String name, String orderDate, String phone) {
        this.adress = adress;
        this.order = order;
        this.employee = employee;
        this.name = name;
        this.orderDate = orderDate;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientId=" + clientId +
                ", adress='" + adress + '\'' +
                ", order='" + order + '\'' +
                ", employee='" + employee + '\'' +
                ", name='" + name + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


