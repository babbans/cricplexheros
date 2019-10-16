package com.aannya.cricplexheros.dto;

public class PlayerProfileDto {
	UserDTO userDTO;
	BatmanStatDtoFinal battingStat;	
	BowlStatDto bowlingStat;
	FielderStatDto fieldingStat;
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public BatmanStatDtoFinal getBattingStat() {
		return battingStat;
	}
	public void setBattingStat(BatmanStatDtoFinal battingStat) {
		this.battingStat = battingStat;
	}
	public BowlStatDto getBowlingStat() {
		return bowlingStat;
	}
	public void setBowlingStat(BowlStatDto bowlingStat) {
		this.bowlingStat = bowlingStat;
	}
	public FielderStatDto getFieldingStat() {
		return fieldingStat;
	}
	public void setFieldingStat(FielderStatDto fieldingStat) {
		this.fieldingStat = fieldingStat;
	}
	
	
	
}
