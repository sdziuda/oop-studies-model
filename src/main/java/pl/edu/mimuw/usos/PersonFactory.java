package pl.edu.mimuw.usos;

import java.util.ArrayList;

public final class PersonFactory {

  private static final Program CS = new Program("MIMUW", "Computer Science");
  private static final Program MATH = new Program("MIMUW", "Math");
  private static int iterator = 1;

  // This class should not be instantiated, therefore it is private.
  private PersonFactory() {
    throw new AssertionError("Suppress default constructor for noninstantiability");
  }

  public static Student createStudent(String firstName, String lastName, String pesel, String number, Program program) {
    return new Student(firstName, lastName, pesel, iterator++, number, new Program(program));
  }

  public static Student createStudent(String firstName, String lastName, String pesel, String number, ArrayList<Program> programs) {
    return new Student(firstName, lastName, pesel, iterator++, number, new ArrayList<>(programs));
  }

  public static Student createCSStudent(String firstName, String lastName, String pesel, String number) {
    return createStudent(firstName, lastName, pesel, number, new Program(CS));
  }

  public static Student createMathStudent(String firstName, String lastName, String pesel, String number) {
    return createStudent(firstName, lastName, pesel, number, new Program(MATH));
  }

  public static Student createJSIMStudent(String firstName, String lastName, String pesel, String number) {
    final var programs = new ArrayList<Program>();
    programs.add(new Program(CS));
    programs.add(new Program(MATH));
    return createStudent(firstName, lastName, pesel, number, programs);
  }

  public static Staff createStaffMember(String firstName, String lastName, String pesel, String position, String degree, String title) {
    return new Staff(firstName, lastName, pesel, iterator++, position, degree, title);
  }
}
