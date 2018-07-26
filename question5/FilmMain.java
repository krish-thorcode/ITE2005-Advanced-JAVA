import java.io.*;
import java.util.Scanner;

class Film {
  String name, language, leadActor, category;
  int duration, yearOfRelease;

  Film() {
    name = language = leadActor = category = "";
    duration = yearOfRelease = 0;
  }

  Film(String name, String language, String leadActor, String category, int duration, int yearOfRelease) {
    this.name = name;
    this.language = language;
    this.leadActor = leadActor;
    this.category = category;
    this.duration = duration;
    this.yearOfRelease = yearOfRelease;
  }

  void setName(String name) {
    this.name = name.toLowerCase();
  }

  void setLanguage(String language) {
    this.language = language.toLowerCase();
  }

  void setLeadActor(String leadActor) {
    this.leadActor = leadActor.toLowerCase();
  }

  void setCategory(String category) {
    this.category = category;
  }

  void setDuration(int duration) {
    this.duration = duration;
  }

  void setYearOfRelease(int yearOfRelease) {
    this.yearOfRelease = yearOfRelease;
  }


  String getName() {
    String returnName = this.name.substring(0,1).toUpperCase() + this.name.substring(1);
    return returnName;
  }

  String getLanguage() {
    String returnLanguage = this.language.substring(0,1).toUpperCase() + this.language.substring(1);
    return returnLanguage;
  }

  String getLeadActor() {
    String returnLeadActor = this.leadActor.substring(0,1).toUpperCase() + this.leadActor.substring(1);
    return returnLeadActor;
  }

  String getCategory() {
    String returnCategory = this.category.substring(0,1).toUpperCase() + this.category.substring(1);
    return returnCategory;
  }

  int getDuration() {
    return this.duration;
  }

  int getYearOfRelease() {
    return this.yearOfRelease;
  }

  // Film[] getArnoldMovies(Film films[]) {
  //   Film[] arnoldFilms = new Film[film.length]
  //   for(Film film: films){
  //     if(film.leadActor == 'Arnold') {}
  //   }
  // }

  Film[] getRajiniFilms(Film films[]) {
    Film[] rajiniFilms = new Film[films.length];
    int count = 0;

    for(Film film: films) {
      if((film.leadActor == "rajinikanth" || film.leadActor == "rajini") && (film.language == "tamil"))
        rajiniFilms[count++] = film;
    }

    return rajiniFilms;
  }

  Film getComedyFilms(Film films[]) {
    Film[] comedyFilms = new Film[films.length];
    int count = 0;

    for(Film film: films) {
      if(film.category == "comedy")
        comedyFilms[count++] = film;
    }

    return comedyFilms;
  }

  Film getComedyFilms(Film films[], String actor) {
    Film[] comedyFilmsWithActor = new Film[films.length];
    actor = actor.toLowerCase();
    int count = 0;

    for(Film film: films) {
      if(film.category == "comedy" && film.leadActor == actor)
        comedyFilmsWithActor[count++] = film;
    }

    return comedyFilmsWithActor;
  }

  Film[][] create2dArray(Film films[]) {

    Film[][] array2d = new Film[6][films.length];
    int counter[6] = new int[6];
    for(Film film: films) {
      if(film.yearOfRelease == 1971)
        array2d[0][count[0]++] = film;
      else if(film.yearOfRelease > 1971 && film.yearOfRelease <=1980 )
        array2d[1][count[1]++] = film;
      else if(film.yearOfRelease >= 1981 && film.yearOfRelease <=1990 )
        array2d[2][count[2]++] = film;
      else if(film.yearOfRelease > 1991 && film.yearOfRelease <=2000 )
        array2d[3][count[3]++] = film;
      else if(film.yearOfRelease > 2001 && film.yearOfRelease <=2010 )
        array2d[4][count[4]++] = film;
      else
        array2d[5][count[5]++] = film;
    }
  }
}

class FilmMain {
  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n;

    System.out.print('Enter the number of movies: ');
    n = scanner.nextInt();

    Film[] films = new Film[n];
    Film film = new Film();
    int numOfFilms = 0;

    for(int i = 0; i<n; i++) {
      System.out.print("Enter film name: ");
      String fname = br.readline();
      film.setName(fname);

      System.out.print("Enter film language: ");
      String lang = br.readline();
      film.setLanguage(lang);

      System.out.print("Enter film lead actor: ");
      String lead = br.readline();
      film.setLeadActor(lead);

      System.out.print("Enter film category: ");
      String category = br.readline();
      film.setCategory(category);

      System.out.print("Enter duration of the film: ");
      int duration = Integer.parseInt(br.readline());
      film.setDuration(duration);

      System.out.print("Enter the year of release: ");
      int yor = Integer.parseInt(br.readline());
      film.setYearOfRelease(yor);

      films[numOfFilms++] = film;
    }
  }
}
