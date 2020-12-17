package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private Date orderDate;
    @OneToMany(mappedBy = "order")
    private Collection<OrderLine> items;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Order(Date orderDate, Collection<OrderLine> items, Client client) {
        this.orderDate = orderDate;
        this.items = items;
        this.client = client;
    }

    public Order() {
        super();
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Collection<OrderLine> getItems() {
        return items;
    }

    public void setItems(Collection<OrderLine> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
