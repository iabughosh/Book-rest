package com.book.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {

	public static enum CategoryType {
		FICTION, MOS, SCIENCE, LANGUAGES, ENTERTAINMENT;
	};

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty(message = "isbn cannot be empty")
	private String isbn;

	@NotNull(message = "categoryType cannot be empty")
	@Enumerated(EnumType.STRING)
	private CategoryType categoryType;

	@Range(min = 5, max = 500, message = "price range is between 5 and 500")
	private Double price;

	@NotEmpty(message = "name cannot be empty")
	private String name;

	@NotEmpty(message = "description cannot be empty")
	private String description;

	private String frontImage;

	private String backImage;

	@Range(min = 0, max = 1000_000, message = "price range is between 0 and 1000000")
	private int totalBuyers;

}
