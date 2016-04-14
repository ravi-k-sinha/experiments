@Grab('com.google.guava:guava:19.0')
import com.google.common.base.*
def result = Splitter.on(',').trimResults(CharMatcher.is('_' as char)).split("_a ,_b_ ,_c_").iterator().toList()
println result

def split(String string) {
    [on : {
        sep -> [
           trimming : {
               trimString -> Splitter.on(sep).trimResults(CharMatcher.anyOf(trimString)).split(string).iterator().toList()
           }
        ]
    }]
}

result = split "_a ,_b_ ,_c_" on ',' trimming " _"
println result
result.forEach {it -> println '[    ' + it + ']'}