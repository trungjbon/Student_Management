package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BirthPlace implements Serializable {
    private int birthPlaceID;
    private String birthPlaceName;

    public BirthPlace(int birthPlaceID, String birthPlaceName) {
        this.birthPlaceID = birthPlaceID;
        this.birthPlaceName = birthPlaceName;
    }

    public static int getProvinceIDByName(String provinceName) {
        for (BirthPlace birthPlace : BirthPlace.getProvinceList()) {
            if (birthPlace.birthPlaceName.equals(provinceName)) {
                return birthPlace.birthPlaceID;
            }
        }
        return -1;
    }

    public int getBirthPlaceID() {
        return birthPlaceID;
    }

    public void setBirthPlaceID(int birthPlaceID) {
        this.birthPlaceID = birthPlaceID;
    }

    public String getBirthPlaceName() {
        return birthPlaceName;
    }

    public void setBirthPlaceName(String birthPlaceName) {
        this.birthPlaceName = birthPlaceName;
    }

    @Override
    public String toString() {
        return "BirthPlace[" +
                "birthPlaceID=" + birthPlaceID +
                ", birthPlaceName=" + birthPlaceName +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BirthPlace birthPlace = (BirthPlace) o;
        return birthPlaceID == birthPlace.birthPlaceID
                && Objects.equals(birthPlaceName, birthPlace.birthPlaceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthPlaceID, birthPlaceName);
    }

    public static ArrayList<BirthPlace> getProvinceList() {
        String[] arrayProvince = {"Hà Giang", "Cao Bằng", "Lào Cai", "Sơn La",
                "Lai Châu", "Bắc Kạn", "Lạng Sơn", "Tuyên Quang", "Yên Bái",
                "Thái Nguyên", "Điện Biên", "Phú Thọ", "Vĩnh Phúc", "Bắc Giang",
                "Bắc Ninh", "Hà Nội", "Quảng Ninh", "Hải Dương", "Hải Phòng",
                "Hòa Bình", "Hưng Yên", "Hà Nam", "Thái Bình", "Nam Định",
                "Ninh Bình", "Thanh Hóa", "Nghệ An", "Hà Tĩnh", "Quảng Bình",
                "Quảng Trị", "Thừa Thiên Huế", "Đà Nẵng", "Quảng Nam", "Quảng Ngãi",
                "Kon Tum", "Gia Lai", "Bình Định", "Phú Yên", "Đắk Lắk", "Khánh Hòa",
                "Đắk Nông", "Lâm Đồng", "Ninh Thuận", "Bình Phước", "Tây Ninh",
                "Bình Dương", "Đồng Nai", "Bình Thuận", "Thành phố Hồ Chí Minh",
                "Long An", "Bà Rịa – Vũng Tàu", "Đồng Tháp", "An Giang", "Tiền Giang",
                "Vĩnh Long", "Bến Tre", "Cần Thơ", "Kiên Giang", "Trà Vinh", "Hậu Giang",
                "Sóc Trăng", "Bạc Liêu", "Cà Mau"
        };
        List<BirthPlace> birthPlaceList = new ArrayList<>();
        for (int i = 0; i < arrayProvince.length; i++) {
            birthPlaceList.add(new BirthPlace(i, arrayProvince[i]));
        }
        return (ArrayList<BirthPlace>) birthPlaceList;
    }
}
