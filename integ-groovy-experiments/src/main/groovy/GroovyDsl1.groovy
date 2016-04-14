show = {println it}

show("Sample Message")

square_root = {Double it -> Math.sqrt(it)}

def please(action) {
    [the: { what ->
        [of: {n -> action(what(n))}]
    }]
}

please show the square_root of 100
please(show).the(square_root).of(100)
