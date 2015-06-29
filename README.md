===================
About Palestine Exchange Financial Ratio Parser - PEXFRP
===================
A "Top Down Recursive Descent Parser" developed to be integrated into "IFSAH" e-disclosure system. The parser checks the compliance of codes with the rules of a non-complex language, designed by Palestine Exchange (PEX) to be used by financial analysts and business experts. The purpose of the language is to grant the business side the ability to build their own financial ratios.

===================
###Project License
===================

    Created By: 'Umar A. Abu Baker. <http://www.geekybedouin.com>
    Copyright (c) 2015 'Umar A.Abu Baker.
    
    PEXFRP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.
    Project Jebr is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.

    This code contains multiple sigments from Project Jebr source code
    Thus the license of Project Jebr should be disclosed
    Created By: 'Umar A.Abu Baker, Fahed N.Shehab <http://www.geekybedouin.com>, <>
    Copyright (c) 2014 'Umar A.Abu Baker and Fahed N.Shehab <umr.baker@gmail.com>, <fahed.shehab@gmail.com>

    Project Jebr is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.
    Project Jebr is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.


====================
###IMPORTANT NOTICE
====================
NOTE: The .java file doesn't contain a main method. Thus, the PEXFRP should be either dynamiclly linked as a .dll or merged as a .jar file
**Provided with the code**: a 32bit dll and a jar file in the dist folder.

====================
###Building from Source
====================
- **Compile from source:**  
	   
	   $javac -g /absPathto/PEXFRP.java
	  
   
	. **Build the dll:** You can build the dlls by using [**IKVM**](http://www.ikvm.net/).
	   
			 
			   $ ikvmc -out:pexfrp.dll 
			  
	. **Or/ Use the generated .jar file**


====================
###How to Use
====================
<br>
- In C#: 
   - Add the dll to project's refrences.
   - Use the code below:
   ```
	com.pex.frp.PEXFRP mx = new com.pex.PEXFRP();
	mx.parseFile(AbsPathtoInput, AbsPathtoOutput);
    ```
- In Java: 
    - Add the jar to project's lib folder
    - Use the code below:
  ```
	PEXFRP mx = new com.pex.PEXFRP();
	mx.parseFile(AbsPathtoInput, AbsPathtoOutput);
  ```

===================
###Source Compilation
===================
 Most of the program can be compiled with any java compiler.
you can obtain the source code from our official [Github Repository](https://github.com/geekybedouin/PEXFRP).


===================
###Contribution
===================
If you want to addup to the project, feel free to fork our [Github repository](https://github.com/geekybedouin/PEXFRP).


