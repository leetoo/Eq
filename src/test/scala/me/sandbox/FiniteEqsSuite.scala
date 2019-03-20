package me.sandbox

import FiniteEqs.boolToBoolToBool
 import org.scalacheck.Arbitrary
 import org.scalactic.Equality
 import org.scalatest.prop.PropertyChecks
 import org.scalatest.{Assertion, Matchers, WordSpec}


class FiniteEqsSuite extends WordSpec with Matchers with PropertyChecks {

  def checkEquivalence[A: Arbitrary: Equality, B: Arbitrary: Equality](eq: Equivalent[A, B]): Assertion = {
    forAll { a: A =>
      assert(eq.from(eq.to(a)) === a)
    }
    forAll { b: B =>
      eq.to(eq.from(b)) shouldBe b
    }
  }
  "checking boolToBoolToBool" should {
    "be a section" in forAll { (f: Boolean => Boolean => Boolean, x: Boolean, y: Boolean) =>
      boolToBoolToBool.from(boolToBoolToBool.to(f))(x)(y) shouldEqual f(x)(y)
    }
    "be a retraction" in forAll { (f: (Boolean => Boolean) => Boolean, g: Boolean => Boolean) =>
      boolToBoolToBool.to(boolToBoolToBool.from(f))(g) shouldEqual f(g)
    }
  }
}



