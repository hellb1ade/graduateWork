module app.graduateproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires java.sql;
    requires java.xml;

    opens app.control;
    opens app.tables;
    opens app.hibernateMain;
}