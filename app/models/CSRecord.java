package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import play.db.jpa.*;
import play.data.validation.*;
import play.data.format.*;

@Entity
public class CSRecord {

    @Id
    public String id;
    public String barcode;
    public String picOneName;
    public String picTwoName;
    public String picThreeName;

    public CSRecord()
    {
	this.id = UUID.randomUUID()+"";
    }

    public String getbarcode() {
	return barcode;
    }

    public void setBarcode(String barcode) {
	this.barcode = barcode;
    }

    public void save() {
        JPA.em().persist(this);
    }

    /*
    static public List<CSRecord> listAll() {
	Query query = JPA.em().createQuery("SELECT r FROM CSRecord r");
	return (List<CSRecord>) query.getResultList();
    }
    */
}
