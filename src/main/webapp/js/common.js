 var HttpRequest = require("nebulas").HttpRequest;
  var Neb = require("nebulas").Neb;
  var Account = require("nebulas").Account;
  var Transaction = require("nebulas").Transaction;
  var Unit = require("nebulas").Unit;
  var neb = new Neb();
  neb.setRequest(new HttpRequest("https://mainnet.nebulas.io"));
  var account, tx, txhash;
  account=new Account();
  var BBSAddress="n1vxJchFxat38g5apgTFvVpB3onYU5peok3";
  var PersonAddress="n1pfebtuxKKCBbd1dwrTCADkEcYftQ2DLQV";
  function readNas(to, funNume ,args,call){
	  var from=account.address?account.getAddressString():to;
	  neb.api.call({
	     chainID: 1,
	     from: from,
	     to: to,
	     value: 0,
	     nonce:  1,
	     gasPrice: 1000000,
	     gasLimit: 200000,
	     contract: {
	         function: funNume,
	         args: args
	     }
	  }).then(call);
}
  function fake_click(obj) {  
	    var ev = document.createEvent("MouseEvents");  
	    ev.initMouseEvent(  
	        "click", true, false, window, 0, 0, 0, 0, 0  
	        , false, false, false, false, 0, null  
	        );  
	    obj.dispatchEvent(ev);  
	}  
	  
	function export_raw(name, data) {  
	    var urlObject = window.URL || window.webkitURL || window;  
	  
	    var export_blob = new Blob([data]);  
	  
	    var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a")  
	    save_link.href = urlObject.createObjectURL(export_blob);  
	    save_link.download = name;  
	    fake_click(save_link);  
	}  
  function setStorage(key,value){
	  if (window.localStorage) {
		    localStorage.setItem(key, value);	
		} else {
		    Cookie.write(key, value);	
		}
  }
  function getStorage(key){
	  if (window.localStorage) {
		  return  localStorage.getItem(key);	
		} else {
			return Cookie.read(key);	
		}
  }
  function deleteStorage(key){
	  if (window.localStorage) {
		  return  localStorage.removeItem(key);	
		} else {
			return Cookie.remove(key);	
		}
  }
  function exit(){
	  deleteStorage("privateKey");
	  location.reload();
  }
   function sendNas(to, funNume ,args,call){
	   if(!account.privKey){
		   layer.msg("请先登录");
		   return
	   }
	   neb.api.getAccountState(account.getAddressString()).then(function (state) {
		   var tx = new Transaction({
			   chainID: 1,
			   from: account,
			   to: to,
			   value: 0,
			   nonce:parseInt(state.nonce) + 1,
			   gasPrice: 1000000,
			   gasLimit: 200000,
			     contract: {
			         function: funNume,
			         args: args
			     }
			});
		   tx.signTransaction();
		   neb.api.sendRawTransaction(tx.toProtoString()).then(call).catch(function (err) {
			   layer.alert(err.message, {icon: 5});
           });
	   });
	}
   function getQueryString(name) {
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	    var r = window.location.search.substr(1).match(reg);
	    if (r != null) return unescape(r[2]); return null;
	}
