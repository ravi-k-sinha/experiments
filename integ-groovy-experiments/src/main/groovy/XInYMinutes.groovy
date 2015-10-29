println "Hello World"

def x = 1
println "Value of x is " + x

x = new java.util.Date()
println "Value of x is " + x

x = -3.1499392
println "Value of x is " + x

x = false
println "Value of x is " + x

x = "Groovy!"
println "Value of x is " + x

def technologies = []
technologies.add("Grails")

technologies << "Groovy"

technologies.addAll(["Gradle", "Griffon"])

technologies.remove("Griffon")

technologies = technologies - 'Grails'

technologies.each {println "Technology: $it"}
technologies.eachWithIndex { it, i -> println "$i: $it" }

contained = technologies.contains('Groovy')

println "Is Groovy contained in technologies " + contained

contained = 'Gradle' in technologies

println "Is Gradle contained in technologies " + contained

bothTechContained = technologies.containsAll(['Groovy', 'Grails'])
println "Are Groovy and Grails both in technologies " + bothTechContained

// To sort without mutating
sortedTechnologies = technologies.sort(false)
println "Original Collection " + technologies
println "Sorted Collection " + sortedTechnologies

technologies.sort()
println "Original Collection - sorted " + technologies

Collections.replaceAll(technologies, "Gradle", "gradle")
println "Value-replaced collection " + technologies

Collections.shuffle(technologies, new Random())
println "Shuffled collection - Round 1" + technologies

Collections.shuffle(technologies, new Random())
println "Shuffled collection - Round 2" + technologies

technologies.clear()
println "Collection after clearing " + technologies

def devMap = [:]

devMap = ['name':'Roberto', 'framework':'Grails', 'language':'Groovy']
devMap.put('lastName', 'Perez')

devMap.each {println "$it.key : $it.value"}
devMap.eachWithIndex{it, i -> println "$i : $it"}

assert devMap.containsKey('name')

assert devMap.containsValue('Roberto')

println devMap.keySet()

println devMap.values()

class Foo {
    // read only property
    final String name = "Roberto"

    // read only property with public getter and protected setter
    String language
    protected void setLanguage(String language) {this.language = language}

    // Dynamically typed property
    def lastName
}

x = 1

if (x == 1) {
    println "One"
}
else if (x == 2) {
    println "Two"
}
else {
    println "x is greater than Two"
}

def y = 10
x = (y > 1) ? "worked" : "failed"

assert x == "worked"

x = 0
for (i in 0 .. 30) {
    x += i
}
println "After for loop, value of x is " + x

x = 0
for (i in [5, 3, 2, 1]) {
    x += i
}
println "After iterating list, value of x is " + x

array = (0..30).toArray()
x = 0
for (i in array) {
    x += i
}
println "After iterating array, value of x is " + x

def map = ['name':'Roberto', 'framework':'Grails', 'language':'Groovy']
x = 0
for ( e in map ) {
    x += e.value
}

println x

technologies = ["Groovy", "Grails", "Gradle"]
upperCaseTechnologies = technologies*.toUpperCase()

println "Spread operator applied : " + upperCaseTechnologies

class User {
    static String get(int i) {
        if (i==0) {
            return null;
        }
        return "name:"+ i
    }
}

def user = User.get(1)
def username = user?.toLowerCase()
println "Lowercase user name (with safe-operator) :" + username

user = User.get(0)
username = user?.toUpperCase()
println "Lowercase user name (with safe-operator, but null) :" + username

def clos = {println "Hello, World!"}

println "Executing the closure:" ; clos()

def sum = {a, b -> println a + b}

sum(2,4)

def x1 = 5
def multiplyBy = {num -> num * x1}

println multiplyBy(10)

clos = {print it * 5 }
clos ("hi")

def cl = {a, b ->
    sleep(3000)
    a + b
}

mem = cl.memoize()

def callClosure(a, b) {
    def start = System.currentTimeMillis()
    mem(a,b)
    println "Inputs (a = $a, b = $b) - took ${System.currentTimeMillis() - start} msecs"
}

callClosure(1, 2)
callClosure(1, 2)
callClosure(2, 3)
callClosure(2, 3)
callClosure(3, 4)
callClosure(3, 4)
callClosure(1, 2)
callClosure(2, 3)
callClosure(3, 4)

def myUser = new Expando(name: "Roberto")

assert 'Roberto' == myUser.name

myUser.lastName = 'Perez'

assert 'Perez' == myUser.lastName

myUser.showInfo = { out ->
    out << "Name: $name"
    out << ", Last name: $lastName"
}

def sw = new StringWriter()
println myUser.showInfo(sw)

String.metaClass.testAdd = {
    println "We added this"
}

String testString = "test"
testString?.testAdd()

class Test implements GroovyInterceptable {

    int counter = 0

    def sum(Integer x, Integer y) {println x + y}

    def invokeMethod(String name, args) {
        System.out.println "Invoke method $name with args; $args"
        if (name.equals("sum")) {
            System.out.println args[0] + args[1]
        }
    }
}

def test = new Test()
test?.sum(2, 3)
test?.multiply(2,3)

class Foo1 {
    def propertyMissing(String name) {name}
}

def f = new Foo1()

assert "boo" == f.boo

import groovy.transform.TypeChecked

void testMethod() {}

//@TypeChecked // Uncomment this line to see type checking in action
void test() {
    testMeethod()

    def name = "Roberto"

    println nameee
}

//@TypeChecked // Uncomment this line to see type checking in action
Integer test1() {
    Integer num = "1"

    Integer[] numbers = [1, 2, 3, 4]

    Date date = numbers[1]

    return "Test"
}

import groovy.transform.CompileStatic

@CompileStatic
int sum1(int x, int y) {
    x + y
}

assert sum1(2,5) == 7










