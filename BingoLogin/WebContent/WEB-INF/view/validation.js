   function trim(s) 
    {
        return s.replace( /^s*/, "" ).replace( /s*$/, "" );
    }

    function validate()
    {
        if(trim(document.frmLogin.uname.value)=="")
        {
          alert("Login empty");
          //document.frmLogin.sUserName.focus();
          return false;
        }
        else if(trim(document.frmLogin.upass.value)=="")
        {
          alert("password empty");
          //document.frmLogin.sPwd.focus();
          return false;
        }
        else if(trim(document.frmLogin.uemail.value)=="")
        {
          alert("email empty");
          //document.frmLogin.sPwd.focus();
          return false;
        }
    }