### HTML generation steps from a Markdown file (Using markdown-styles)

1. Installation of NodeJS
   1. Install globally on localhost (For e.g. using apt-get on Ubuntu)
   2. Install by exploding compressed file from NodeJS [website](https://nodejs.org)
      Prefer this way when need to control multiple versions of NodeJS on your system

   ** Installation of NodeJS gives you npm. Adjust your system paths accordingly so that npm is available on command line

2. Installation of markdown-styles

   markdown-styles is a NodeJS application that can be used to generate HTML from a source markdown file

   1. Install the markdown as described on its [website](http://mixu.net/markdown-styles)
      1. For instance on Ubuntu the command for installation would be

         <code>sudo npm install -g markdown-styles</code>

         Adjust the system paths accordingly so that `generate-md` is available on command-line


3. Using markdown-styles to generate HTML

   markdown-styles usage has been described on its [website](http://mixu.net/markdown-styles)

   1. Choose a source markdown file from which HTML needs to be generated
   2. Use following command to generate the HTML

      <code>generate-md --layout github --input ./SampleMarkdown.md --output ./output</code>

      1. `github` is one of the available layouts.
      2. If for the selected layout, there are assets to be copied (e.g. CSS files, etc.), they will be copied into the specified output folder along with the generated html file
   3. Use your favorite browser to open the html file to read.

** Above steps are for HTML file generation from a single source markdown file. markdwon-styles supports usage of `handlebars` to generate from templated markdown files (e.g. with separate files for headers, footer, etc.)

