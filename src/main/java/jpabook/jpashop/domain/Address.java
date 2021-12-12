package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * Create Address value class
 */

@Embeddable
@Getter //@Setter를 제거, 생성자 값을 모두 초기화해서 변경 불가능한 클래스 생성
public class Address {

    private String city;
    private String street;
    private String zipcode;

    //함부로 new 생성 x,
    //protected로 설정해서 안전성 강화
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
