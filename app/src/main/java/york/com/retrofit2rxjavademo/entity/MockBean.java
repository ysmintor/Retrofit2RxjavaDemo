package york.com.retrofit2rxjavademo.entity;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo.entity
 * @Description:    MockBean
 * @time 2017/3/27 10:54
 */
public class MockBean {
    /**
     * address : 北京市海淀区清华大学
     * website : www.tsinghua.edu.cn
     * email : zsb@mail.tsinghua.edu.cn
     * parent : 教育部
     * type :  211 985
     * phone : 010-62770334;010-62782051
     * info : 院士：68人 博士点：198个 硕士点：181个
     * city : 北京
     * name : 清华大学
     * profile : 清华简历清华简历清华简历清华简历
     * img : http://img.jidichong.com/school/3.png
     * zipcode : 01022
     */

    private String address;
    private String website;
    private String email;
    private String parent;
    private String type;
    private String phone;
    private String info;
    private String city;
    private String name;
    private String profile;
    private String img;
    private String zipcode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "MockBean{" +
                "address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", parent='" + parent + '\'' +
                ", type='" + type + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", img='" + img + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
