package project.app;

import project.Models.MockBookService;

public class test {
    public static void main(String[] args) {
        Long l = 1L;
        System.out.println(l+1);

        MockBookService mockBookService = new MockBookService();

        System.out.println(mockBookService.getBooks());
    }
}
