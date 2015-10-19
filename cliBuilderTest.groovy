#!/usr/bin/groovy

import org.apache.commons.cli.Option
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import uk.ac.starlink.gbin.GbinTableBuilder
import uk.ac.starlink.table.StarTable
import uk.ac.starlink.table.StarTableFactory

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


def cli = new CliBuilder(usage: '-d <directory> -op <options>   -i <input> : -o <output>', 
header: '\nLine argument testing ')

cli.i longOpt: 'input',  ' input data with several arguments', args:Option.UNLIMITED_VALUES, valueSeparator: ','
cli.h longOpt: 'help', 'print usage information'
cli.d longOpt: 'dir',' directory', args:Option.UNLIMITED_VALUES
cli.o longOpt: 'output', args:1,  'output data'
cli.op longOpt: 'options', args:1,  'file options'



def opt=cli.parse(args)
def errMsg = "Invalid arguments for this script\n" 

if(!opt){
println" bad argumens\n"
}else if(opt.h){
cli.usage()
}else if(opt.arguments().size !=1){
println errMsg
}
else if(opt.i){
input=cli.i
return input
}else if(opt.o){
output=cli.o
return output
}else if(opt.d){
directory=cli.d
return directory
}

def rootDir= "/home/user/Documents/gbintool/src/test/resources"
println rootDir

new File(rootDir).eachFileMatch(~/.*\.gbin/) {println it}

