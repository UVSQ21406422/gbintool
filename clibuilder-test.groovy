def cli = new CliBuilder(usage: 'cli-test -d <argument>')

cli.with {
  h(longOpt: 'help', 'usage information')
  d(longOpt: 'do-something', required: true, args: 1, 'Do Something' )
}

OptionAccessor options = cli.parse(args)
if(!options) {
  return
}

// print usage if -h, --help, or no argument is given
if(options.h || options.arguments().isEmpty()) {
  println options.arguments().size()
  cli.usage()
  return
} else if (options.d) {
  println options.d
}