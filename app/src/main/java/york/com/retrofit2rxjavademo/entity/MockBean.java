package york.com.retrofit2rxjavademo.entity;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Retrofit2RxjavaDemo
 * @Package york.com.retrofit2rxjavademo.entity
 * @Description:
 * @time 2017/3/7 15:39
 */
public class MockBean {
    /**
     * departmentsName : sdf
     * technicalTitleName : sdf
     * headPic : sdf
     * description : sdf
     * accountId : 26
     * signature : sdf
     * technicalTitleCode : sdf
     * doctorId : 26
     * provinceId : 123
     * hospitalId : 12
     * departmentsId : 345
     * name : sd
     * token : jsdfhskjfhsofj
     * hospitalName : 234e
     * provinceName : sdf
     */

    private String departmentsName;
    private String technicalTitleName;
    private String headPic;
    private String description;
    private int accountId;
    private String signature;
    private String technicalTitleCode;
    private int doctorId;
    private int provinceId;
    private int hospitalId;
    private int departmentsId;
    private String name;
    private String token;
    private String hospitalName;
    private String provinceName;

    public String getDepartmentsName() {
        return departmentsName;
    }

    public void setDepartmentsName(String departmentsName) {
        this.departmentsName = departmentsName;
    }

    public String getTechnicalTitleName() {
        return technicalTitleName;
    }

    public void setTechnicalTitleName(String technicalTitleName) {
        this.technicalTitleName = technicalTitleName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTechnicalTitleCode() {
        return technicalTitleCode;
    }

    public void setTechnicalTitleCode(String technicalTitleCode) {
        this.technicalTitleCode = technicalTitleCode;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "MockBean{" +
                "departmentsName='" + departmentsName + '\'' +
                ", technicalTitleName='" + technicalTitleName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", description='" + description + '\'' +
                ", accountId=" + accountId +
                ", signature='" + signature + '\'' +
                ", technicalTitleCode='" + technicalTitleCode + '\'' +
                ", doctorId=" + doctorId +
                ", provinceId=" + provinceId +
                ", hospitalId=" + hospitalId +
                ", departmentsId=" + departmentsId +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
