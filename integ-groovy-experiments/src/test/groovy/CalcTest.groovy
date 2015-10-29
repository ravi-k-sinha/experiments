class CalcTest extends GroovyTestCase {

    Calc myCalc

    void testAddition() {
        myCalc = new Calc()
        assert myCalc.add(2) == 2
        assert myCalc.add(2) != 2
    }

    void testSubtraction() {
        myCalc = new Calc()
        assert myCalc.sub(2) == -2
    }

    void testProduct() {
        myCalc = new Calc(res:1)
        assert myCalc.prod(3) == 3
    }

    void testDivision() {
        myCalc = new Calc(res:10)
        assert myCalc.div(5) == 2
    }

    void testCombine() {
        myCalc = new Calc()
        assert myCalc.add(2) == 2
        assert myCalc.add(2) == 4
        assert myCalc.sub(1) == 3
        assert myCalc.sub(1) == 2
        assert myCalc.prod(2) == 4
        assert myCalc.prod(3) == 12
        assert myCalc.div(2) == 6
    }

    void testError() {
        myCalc = new Calc(res:1)
        shouldFail {
            myCalc.prod("a")
        }
    }
}
