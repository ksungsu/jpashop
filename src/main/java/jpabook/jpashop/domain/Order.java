package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

/**
 * Create order Entity
 */

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)  //멤버와 다(order)대일(member) 관계
    @JoinColumn(name = "member_id") //외래키 설정, 이름 설정
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문 시간

    @Enumerated(EnumType.STRING)
    private OrderState orderState; //주문상태 [ORDER, CANCEL]

//    public static void main(String[] args) {
//        Member member = new Member();
//        Order order = new Order();
//
//        member.getOrders().add(order);
//        order.setMember(member);
//    }
    //==연관관계 편의 메서드==// 위 주석된 코드를 아래 메서드와 같이 설정 가능.
        public void setMember(Member member){
            this.member = member;
            member.getOrders().add(this);   //this is ordered person
        }

        public void addOrderItem(OrderItem orderItem){
            orderItems.add(orderItem);
            orderItem.setOrder(this);
        }

        public void setDelivery(Delivery delivery){
            this.delivery = delivery;
            delivery.setOrder(this);
        }
}
