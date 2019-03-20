package me.sandbox

/*
 * must satisfy a rule
 * from(to(a : A)) == a
 * to(from(b : B)) == b
 */
object Pg extends App {
  println("compile ")
}
trait Equivalent[A, B] {
  def to(a: A): B
  def from(b: B): A
}
object Equivalent {
  def apply[A, B](fto: A => B)(ffrom: B => A): Equivalent[A, B] =
    new Equivalent[A, B] {
      def to(a: A): B = fto(a)

      def from(b: B): A = ffrom(b)
    }
}
object FiniteEqs {
  val boolToBoolToBool: Equivalent[Boolean => Boolean => Boolean,
                                   (Boolean => Boolean) => Boolean] = {

    val fffrom = (f: (Boolean => Boolean) => Boolean) =>
      (a: Boolean) => (b: Boolean) => f(a => b)

    def tto =

      (m: Boolean => Boolean => Boolean) => (f: Boolean => Boolean) => f(true)
    Equivalent

      .apply[Boolean => Boolean => Boolean, (Boolean => Boolean) => Boolean](
        tto)(fffrom)
  }
}
