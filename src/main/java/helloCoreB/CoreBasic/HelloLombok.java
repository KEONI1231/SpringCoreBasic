package helloCoreB.CoreBasic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//Lombok 라이브러리
//Getter setter 자동 생성

@Getter
@Setter
@ToString
public class HelloLombok {
    public String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("김건휘");
        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);

    }
}
