package org.hibernate.validator.referenceguide.chapter01;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class Car {

    @NotNull(message = "manufacturer must not be null.")
    private String manufacturer;

    @NotNull
    @Size(min = 2,max = 14,message = "licensePlate must between {min} and {max}")
    private String licensePlate;

    @Min(value = 2,message = "seatCount must be greater than or equal to {value}")
    private int seatCount;

    @NotNull(message = "buyTime must not be null")
    @Past(message = "buyTime must be past time.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//<mvn:annotation/>
    private Date buyTime;

    @NotNull(message = "list must not be null.")
    @ListStringPattern(regexp = "[a-z0-9]{32}",message = "String in list must be 32 bit.")
    @Size(min = 3,max = 5,message = "list的Size在[{min},{max}]")//the list.size between {min} and {max}
    private List<String> list;

    public Car(@NotNull String manufacturer, @NotNull @Size(min = 2, max = 14) String licensePlate, @Min(2) int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
    }

    public Car(@NotNull(message = "manufacturer must not be null.") String manufacturer, @NotNull @Size(min = 2, max = 14, message = "licensePlate must between {min} and {max}") String licensePlate, @Min(2) int seatCount, @NotBlank(message = "buyTime must not be blank") Date buyTime) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.buyTime = buyTime;
    }

    public Car(@NotNull(message = "manufacturer must not be null.") String manufacturer, @NotNull @Size(min = 2, max = 14, message = "licensePlate must between {min} and {max}") String licensePlate, @Min(value = 2, message = "seatCount must be greater than or equal to {value}") int seatCount, @Size(min = 3, max = 5, message = "list的Size在[{min},{max}]") List<String> list) {
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.list = list;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }
}

