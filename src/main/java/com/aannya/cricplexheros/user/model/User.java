package com.aannya.cricplexheros.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long user_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="langlat")
	private String langlat;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fb_id")
	private String fb_id;
	
	@Column(name="g_id")
	private String g_id;
	
	@Column(name="g_photo")
	private String g_photo;
	
	@Column(name="google_plus")
	private String google_plus;
	
	@Column(name="skype")
	private String skype;
	
	@Column(name="facebook")
	private String facebook;
	
	@Column(name="wishlist")
	private String wishlist;
	
	@Column(name="last_login")
	private String last_login;
	
	@Column(name="user_type")
	private String user_type;
	
	@Column(name="user_type_till")
	private String user_type_till;
	
	@Column(name="left_product_type")
	private String left_product_type;
	
	@Column(name="downloads")
	private String downloads;

	@Column(name="state")
	private String state;
	
	@Column(name="wallet")
	private String wallet;
	
	@Column(name="get_coin")
	private long get_coin;
	
	@Column(name="total_coin")
	private long total_coin;
	
	@Column(name="coin_start_date")
	private String coin_start_date;
	
	@Column(name="product_upload")
	private long product_upload;
	
	@Column(name="batting_style")
	private String batting_style;
	
	@Column(name="package_info")
	private String package_info;
	
	@Column(name="static_coin")
	private long static_coin;
	
	@Column(name="location")
	private String location;
	
	@Column(name="country")
	private String country;
	
	@Column(name="DOB")
	private String dob;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile_number")
	private String mobile_number;
	
	@Column(name="player_role")
	private String player_role;	
	
	@Column(name="bowling_style")
	private String bowling_style;
	
	@Column(name="profile_img_Path")
	private String profile_img_Path;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="team_id")
	private String team_id;
		
	@Column(name="is_active")
	private String is_active;
	
	@Column(name="creation_date")
	private String creation_date;
	
	@Column(name="updated_on")
	private Date updated_on;
	
	@Column(name="created_date")
	private Date created_date;

	public User() {
		
	}

	public User(long user_id, String name, String username, String surname, String phone, String picture,
			String address1, String address2, String city, String zip, String langlat, String password, String fb_id,
			String g_id, String g_photo, String google_plus, String skype, String facebook, String wishlist,
			String last_login, String user_type, String user_type_till, String left_product_type, String downloads,
			String state, String wallet, long get_coin, long total_coin, String coin_start_date, long product_upload,
			String batting_style, String package_info, long static_coin, String location, String country, String dob,
			String email, String mobile_number, String player_role, String bowling_style, String profile_img_Path,
			String pin, String team_id, String is_active, String creation_date, Date updated_on, Date created_date) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.username = username;
		this.surname = surname;
		this.phone = phone;
		this.picture = picture;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.langlat = langlat;
		this.password = password;
		this.fb_id = fb_id;
		this.g_id = g_id;
		this.g_photo = g_photo;
		this.google_plus = google_plus;
		this.skype = skype;
		this.facebook = facebook;
		this.wishlist = wishlist;
		this.last_login = last_login;
		this.user_type = user_type;
		this.user_type_till = user_type_till;
		this.left_product_type = left_product_type;
		this.downloads = downloads;
		this.state = state;
		this.wallet = wallet;
		this.get_coin = get_coin;
		this.total_coin = total_coin;
		this.coin_start_date = coin_start_date;
		this.product_upload = product_upload;
		this.batting_style = batting_style;
		this.package_info = package_info;
		this.static_coin = static_coin;
		this.location = location;
		this.country = country;
		this.dob = dob;
		this.email = email;
		this.mobile_number = mobile_number;
		this.player_role = player_role;
		this.bowling_style = bowling_style;
		this.profile_img_Path = profile_img_Path;
		this.pin = pin;
		this.team_id = team_id;
		this.is_active = is_active;
		this.creation_date = creation_date;
		this.updated_on = updated_on;
		this.created_date = created_date;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLanglat() {
		return langlat;
	}

	public void setLanglat(String langlat) {
		this.langlat = langlat;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFb_id() {
		return fb_id;
	}

	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}

	public String getG_id() {
		return g_id;
	}

	public void setG_id(String g_id) {
		this.g_id = g_id;
	}

	public String getG_photo() {
		return g_photo;
	}

	public void setG_photo(String g_photo) {
		this.g_photo = g_photo;
	}

	public String getGoogle_plus() {
		return google_plus;
	}

	public void setGoogle_plus(String google_plus) {
		this.google_plus = google_plus;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getWishlist() {
		return wishlist;
	}

	public void setWishlist(String wishlist) {
		this.wishlist = wishlist;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_type_till() {
		return user_type_till;
	}

	public void setUser_type_till(String user_type_till) {
		this.user_type_till = user_type_till;
	}

	public String getLeft_product_type() {
		return left_product_type;
	}

	public void setLeft_product_type(String left_product_type) {
		this.left_product_type = left_product_type;
	}

	public String getDownloads() {
		return downloads;
	}

	public void setDownloads(String downloads) {
		this.downloads = downloads;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getWallet() {
		return wallet;
	}

	public void setWallet(String wallet) {
		this.wallet = wallet;
	}

	public long getGet_coin() {
		return get_coin;
	}

	public void setGet_coin(long get_coin) {
		this.get_coin = get_coin;
	}

	public long getTotal_coin() {
		return total_coin;
	}

	public void setTotal_coin(long total_coin) {
		this.total_coin = total_coin;
	}

	public String getCoin_start_date() {
		return coin_start_date;
	}

	public void setCoin_start_date(String coin_start_date) {
		this.coin_start_date = coin_start_date;
	}

	public long getProduct_upload() {
		return product_upload;
	}

	public void setProduct_upload(long product_upload) {
		this.product_upload = product_upload;
	}

	public String getBatting_style() {
		return batting_style;
	}

	public void setBatting_style(String batting_style) {
		this.batting_style = batting_style;
	}

	public String getPackage_info() {
		return package_info;
	}

	public void setPackage_info(String package_info) {
		this.package_info = package_info;
	}

	public long getStatic_coin() {
		return static_coin;
	}

	public void setStatic_coin(long static_coin) {
		this.static_coin = static_coin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getPlayer_role() {
		return player_role;
	}

	public void setPlayer_role(String player_role) {
		this.player_role = player_role;
	}

	public String getBowling_style() {
		return bowling_style;
	}

	public void setBowling_style(String bowling_style) {
		this.bowling_style = bowling_style;
	}

	public String getProfile_img_Path() {
		return profile_img_Path;
	}

	public void setProfile_img_Path(String profile_img_Path) {
		this.profile_img_Path = profile_img_Path;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + ((batting_style == null) ? 0 : batting_style.hashCode());
		result = prime * result + ((bowling_style == null) ? 0 : bowling_style.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((coin_start_date == null) ? 0 : coin_start_date.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((created_date == null) ? 0 : created_date.hashCode());
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((downloads == null) ? 0 : downloads.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + ((fb_id == null) ? 0 : fb_id.hashCode());
		result = prime * result + ((g_id == null) ? 0 : g_id.hashCode());
		result = prime * result + ((g_photo == null) ? 0 : g_photo.hashCode());
		result = prime * result + (int) (get_coin ^ (get_coin >>> 32));
		result = prime * result + ((google_plus == null) ? 0 : google_plus.hashCode());
		result = prime * result + ((is_active == null) ? 0 : is_active.hashCode());
		result = prime * result + ((langlat == null) ? 0 : langlat.hashCode());
		result = prime * result + ((last_login == null) ? 0 : last_login.hashCode());
		result = prime * result + ((left_product_type == null) ? 0 : left_product_type.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((mobile_number == null) ? 0 : mobile_number.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((package_info == null) ? 0 : package_info.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result + ((pin == null) ? 0 : pin.hashCode());
		result = prime * result + ((player_role == null) ? 0 : player_role.hashCode());
		result = prime * result + (int) (product_upload ^ (product_upload >>> 32));
		result = prime * result + ((profile_img_Path == null) ? 0 : profile_img_Path.hashCode());
		result = prime * result + ((skype == null) ? 0 : skype.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + (int) (static_coin ^ (static_coin >>> 32));
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((team_id == null) ? 0 : team_id.hashCode());
		result = prime * result + (int) (total_coin ^ (total_coin >>> 32));
		result = prime * result + ((updated_on == null) ? 0 : updated_on.hashCode());
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
		result = prime * result + ((user_type == null) ? 0 : user_type.hashCode());
		result = prime * result + ((user_type_till == null) ? 0 : user_type_till.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((wallet == null) ? 0 : wallet.hashCode());
		result = prime * result + ((wishlist == null) ? 0 : wishlist.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address1 == null) {
			if (other.address1 != null)
				return false;
		} else if (!address1.equals(other.address1))
			return false;
		if (address2 == null) {
			if (other.address2 != null)
				return false;
		} else if (!address2.equals(other.address2))
			return false;
		if (batting_style == null) {
			if (other.batting_style != null)
				return false;
		} else if (!batting_style.equals(other.batting_style))
			return false;
		if (bowling_style == null) {
			if (other.bowling_style != null)
				return false;
		} else if (!bowling_style.equals(other.bowling_style))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (coin_start_date == null) {
			if (other.coin_start_date != null)
				return false;
		} else if (!coin_start_date.equals(other.coin_start_date))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (created_date == null) {
			if (other.created_date != null)
				return false;
		} else if (!created_date.equals(other.created_date))
			return false;
		if (creation_date == null) {
			if (other.creation_date != null)
				return false;
		} else if (!creation_date.equals(other.creation_date))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (downloads == null) {
			if (other.downloads != null)
				return false;
		} else if (!downloads.equals(other.downloads))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (fb_id == null) {
			if (other.fb_id != null)
				return false;
		} else if (!fb_id.equals(other.fb_id))
			return false;
		if (g_id == null) {
			if (other.g_id != null)
				return false;
		} else if (!g_id.equals(other.g_id))
			return false;
		if (g_photo == null) {
			if (other.g_photo != null)
				return false;
		} else if (!g_photo.equals(other.g_photo))
			return false;
		if (get_coin != other.get_coin)
			return false;
		if (google_plus == null) {
			if (other.google_plus != null)
				return false;
		} else if (!google_plus.equals(other.google_plus))
			return false;
		if (is_active == null) {
			if (other.is_active != null)
				return false;
		} else if (!is_active.equals(other.is_active))
			return false;
		if (langlat == null) {
			if (other.langlat != null)
				return false;
		} else if (!langlat.equals(other.langlat))
			return false;
		if (last_login == null) {
			if (other.last_login != null)
				return false;
		} else if (!last_login.equals(other.last_login))
			return false;
		if (left_product_type == null) {
			if (other.left_product_type != null)
				return false;
		} else if (!left_product_type.equals(other.left_product_type))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (mobile_number == null) {
			if (other.mobile_number != null)
				return false;
		} else if (!mobile_number.equals(other.mobile_number))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (package_info == null) {
			if (other.package_info != null)
				return false;
		} else if (!package_info.equals(other.package_info))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
			return false;
		if (pin == null) {
			if (other.pin != null)
				return false;
		} else if (!pin.equals(other.pin))
			return false;
		if (player_role == null) {
			if (other.player_role != null)
				return false;
		} else if (!player_role.equals(other.player_role))
			return false;
		if (product_upload != other.product_upload)
			return false;
		if (profile_img_Path == null) {
			if (other.profile_img_Path != null)
				return false;
		} else if (!profile_img_Path.equals(other.profile_img_Path))
			return false;
		if (skype == null) {
			if (other.skype != null)
				return false;
		} else if (!skype.equals(other.skype))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (static_coin != other.static_coin)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (team_id == null) {
			if (other.team_id != null)
				return false;
		} else if (!team_id.equals(other.team_id))
			return false;
		if (total_coin != other.total_coin)
			return false;
		if (updated_on == null) {
			if (other.updated_on != null)
				return false;
		} else if (!updated_on.equals(other.updated_on))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_type == null) {
			if (other.user_type != null)
				return false;
		} else if (!user_type.equals(other.user_type))
			return false;
		if (user_type_till == null) {
			if (other.user_type_till != null)
				return false;
		} else if (!user_type_till.equals(other.user_type_till))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (wallet == null) {
			if (other.wallet != null)
				return false;
		} else if (!wallet.equals(other.wallet))
			return false;
		if (wishlist == null) {
			if (other.wishlist != null)
				return false;
		} else if (!wishlist.equals(other.wishlist))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	
}
