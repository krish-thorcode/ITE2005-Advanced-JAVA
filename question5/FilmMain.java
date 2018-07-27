import java.io.*;
import java.util.Scanner;

class Film {
  private String name, language, leadActor, category;
  private int duration, yearOfRelease;

  public Film() {
    name = language = leadActor = category = "";
    duration = yearOfRelease = 0;
  }

  public Film(String name, String language, String leadActor, String category, int duration, int yearOfRelease) {
    this.name = name;
    this.language = language;
    this.leadActor = leadActor;
    this.category = category;
    this.duration = duration;
    this.yearOfRelease = yearOfRelease;
  }

  public void setName(String name) {
    this.name = name.toLowerCase();
  }

  public void setLanguage(String language) {
    this.language = language.toLowerCase();
  }

  public void setLeadActor(String leadActor) {
    this.leadActor = leadActor.toLowerCase();
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setYearOfRelease(int yearOfRelease) {
    this.yearOfRelease = yearOfRelease;
  }


  public String getName() {
    String returnName = this.name.substring(0,1).toUpperCase() + this.name.substring(1);
    return returnName;
  }

  public String getLanguage() {
    String returnLanguage = this.language.substring(0,1).toUpperCase() + this.language.substring(1);
    return returnLanguage;
  }

  public String getLeadActor() {
    String returnLeadActor = this.leadActor.substring(0,1).toUpperCase() + this.leadActor.substring(1);
    return returnLeadActor;
  }

  public String getCategory() {
    String returnCategory = this.category.substring(0,1).toUpperCase() + this.category.substring(1);
    return returnCategory;
  }

  public int getDuration() {
    return this.duration;
  }

  public int getYearOfRelease() {
    return this.yearOfRelease;
  }

  // Film[] getArnoldFilms(Film films[]) {
  //   Film[] arnoldFilms = new Film[film.length]
  //   for(Film film: films){
  //     if(film.leadActor == "Arnold") {}
  //   }
  // }


}

class SourceOfFunctions {

  Film[][] create2dArray(Film films[]) {

    Film[][] array2d = new Film[6][films.length];
    int counter[] = new int[6];
    for(Film film: films) {
      if(film.getYearOfRelease() == 1971)
        array2d[0][counter[0]++] = film;
      else if(film.getYearOfRelease() > 1971 && film.getYearOfRelease() <=1980 )
        array2d[1][counter[1]++] = film;
      else if(film.getYearOfRelease() >= 1981 && film.getYearOfRelease() <=1990 )
        array2d[2][counter[2]++] = film;
      else if(film.getYearOfRelease() > 1991 && film.getYearOfRelease() <=2000 )
        array2d[3][counter[3]++] = film;
      else if(film.getYearOfRelease() > 2001 && film.getYearOfRelease() <=2010 )
        array2d[4][counter[4]++] = film;
      else
        array2d[5][counter[5]++] = film;
    }

    return array2d;
  }

  Film[] getRajiniFilms(Film films[]) {
    Film[] rajiniFilms = new Film[films.length];
    int count = 0;

    for(Film film: films) {
      if((film.getLeadActor() == "rajinikanth" || film.getLeadActor() == "rajini") && (film.getLanguage() == "tamil"))
        rajiniFilms[count++] = film;
    }

    return rajiniFilms;
  }

  Film[] getArnoldFilms(Film films[]) {
    Film[] arnoldFilms = new Film[films.length];
    int count = 0;

    for(Film film: films) {
      if((film.getLeadActor() == "arnold" || film.getLeadActor() == "arnold") && (film.getLanguage() == "english"))
        arnoldFilms[count++] = film;
    }

    return arnoldFilms;
  }

  Film[] getComedyFilms(Film films[]) {
    Film[] comedyFilms = new Film[films.length];
    int count = 0;

    for(Film film: films) {
      if(film.getCategory() == "comedy")
        comedyFilms[count++] = film;
    }

    return comedyFilms;
  }

  Film[] getComedyFilms(Film films[], String actor) {
    Film[] comedyFilmsWithActor = new Film[films.length];
    actor = actor.toLowerCase();
    int count = 0;

    for(Film film: films) {
      if(film.getCategory() == "comedy" && film.getLeadActor() == actor)
        comedyFilmsWithActor[count++] = film;
    }

    return comedyFilmsWithActor;
  }

  Film getShortestFilm(Film[] films) {

    Film shortestFilm = films[0];
    for(Film film: films) {
      if(shortestFilm.getDuration() > film.getDuration())
        shortestFilm = film;
    }

    return shortestFilm;
  }
}

class FilmMain {
  public static void main(String args[]) throws IOException {

    Scanner scanner = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n;

    System.out.print("Enter the number of movies: ");
    n = scanner.nextInt();

    Film[] films = new Film[n];
    Film film = new Film();
    int numOfFilms = 0;

    for(int i = 0; i<n; i++) {
      System.out.println("Film " + i + ":");
      System.out.println("-------");
      System.out.print("Enter film name: ");
      String fname = br.readLine();
      film.setName(fname);

      System.out.print("Enter film language: ");
      String lang = br.readLine();
      film.setLanguage(lang);

      System.out.print("Enter film lead actor: ");
      String lead = br.readLine();
      film.setLeadActor(lead);

      System.out.print("Enter film category: ");
      String category = br.readLine();
      film.setCategory(category);

      System.out.print("Enter duration of the film: ");
      int duration = Integer.parseInt(br.readLine());
      film.setDuration(duration);

      System.out.print("Enter the year of release: ");
      int yor = Integer.parseInt(br.readLine());
      film.setYearOfRelease(yor);

      films[numOfFilms++] = film;
    }

    SourceOfFunctions sof = new SourceOfFunctions();

    Film[] rajiniFilms = sof.getRajiniFilms(films);
    System.out.println(rajiniFilms.length);
    Film[] arnoldFilms = sof.getArnoldFilms(films);
    System.out.println(arnoldFilms.length);
    Film[] comedyFilms = sof.getComedyFilms(films);
    System.out.println(comedyFilms.length);

    for(Film rajiniFilm: rajiniFilms) {
      System.out.println("Film name: " + rajiniFilm.getName());
      System.out.println("Film language: " + rajiniFilm.getLanguage());
      System.out.println("Film actor: " + rajiniFilm.getLeadActor());
      System.out.println("Film category: " + rajiniFilm.getCategory());
      System.out.println("Film duration: " + rajiniFilm.getDuration());
      System.out.println("Film yearOfRelease: " + rajiniFilm.getYearOfRelease());
    }

    for(Film arnoldFilm: arnoldFilms) {
      System.out.println("Film name: " + arnoldFilm.getName());
      System.out.println("Film language: " + arnoldFilm.getLanguage());
      System.out.println("Film actor: " + arnoldFilm.getLeadActor());
      System.out.println("Film category: " + arnoldFilm.getCategory());
      System.out.println("Film duration: " + arnoldFilm.getDuration());
      System.out.println("Film yearOfRelease: " + arnoldFilm.getYearOfRelease());
    }

    Film shortestFilm = sof.getShortestFilm(arnoldFilms);
    System.out.println("Shortest Arnold film: " + shortestFilm);

    for(Film comedyFilm: comedyFilms) {
      System.out.println("Film name: " + comedyFilm.getName());
      System.out.println("Film language: " + comedyFilm.getLanguage());
      System.out.println("Film actor: " + comedyFilm.getLeadActor());
      System.out.println("Film category: " + comedyFilm.getCategory());
      System.out.println("Film duration: " + comedyFilm.getDuration());
      System.out.println("Film yearOfRelease: " + comedyFilm.getYearOfRelease());
    }

    System.out.println("Enter the actor to get his comedy movies: ");
    String actor = br.readLine();

    Film[] actorComedyFilms = sof.getComedyFilms(films, actor);

    for(Film comedyFilm: actorComedyFilms) {
      System.out.println("Film name: " + comedyFilm.getName());
      System.out.println("Film language: " + comedyFilm.getLanguage());
      System.out.println("Film actor: " + comedyFilm.getLeadActor());
      System.out.println("Film category: " + comedyFilm.getCategory());
      System.out.println("Film duration: " + comedyFilm.getDuration());
      System.out.println("Film yearOfRelease: " + comedyFilm.getYearOfRelease());
    }
  }
}
