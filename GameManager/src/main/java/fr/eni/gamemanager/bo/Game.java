package fr.eni.gamemanager.bo;

import java.time.LocalDate;

public class Game { // POJO
	// attrs
	private int id;
	private String name;
	private String company;
	private String category;
	private float price;
	private LocalDate releaseDate;
	private int age;
	private String format;
	private String version;
	private String jaquette;
	// constructeur
	
	public Game() {}
	
	public Game(int id, String name, String company, String category, float price, LocalDate releaseDate, int age,
			String format, String version, String jaquette) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.category = category;
		this.price = price;
		this.releaseDate = releaseDate;
		this.age = age;
		this.format = format;
		this.version = version;
		this.jaquette = jaquette;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getJaquette() {
		return jaquette;
	}

	public void setJaquette(String jaquette) {
		this.jaquette = jaquette;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", company=" + company + ", category=" + category + ", price="
				+ price + ", releaseDate=" + releaseDate + ", age=" + age + ", format=" + format + ", version="
				+ version + ", jaquette=" + jaquette + "]";
	}
	
	
	
}
