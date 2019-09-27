Simple pojo's with junit test to solve checkout system

I've made some assumptions in how the system would work, 
i think it would just be a case of adding the correct annotations to make this run
in a springBoot environment.

Code: noths/impl/CheckOutImpl.java

Test: noths/impl/CheckOutImplTest.java

I've just assumed something would call the CheckOut class 
either a controller or servlet, please use the unit test if you want to do some
further manipulations.

***
To Build: mvn clean install
