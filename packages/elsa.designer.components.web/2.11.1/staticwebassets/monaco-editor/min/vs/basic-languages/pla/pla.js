/*! For license information please see pla.js.LICENSE.txt */
define("vs/basic-languages/pla/pla",["require","require"],(e=>(()=>{var e,t=Object.defineProperty,o=Object.getOwnPropertyDescriptor,n=Object.getOwnPropertyNames,r=Object.prototype.hasOwnProperty,s=(e="undefined"!=typeof WeakMap?new WeakMap:0,(s,a)=>e&&e.get(s)||(a=((e,s,a,i)=>{if(s&&"object"==typeof s||"function"==typeof s)for(let a of n(s))!r.call(e,a)&&t(e,a,{get:()=>s[a],enumerable:!(i=o(s,a))||i.enumerable});return e})(t({},"__esModule",{value:!0}),s),e&&e.set(s,a),a)),a={};((e,o)=>{for(var n in o)t(e,n,{get:o[n],enumerable:!0})})(a,{conf:()=>i,language:()=>p});var i={comments:{lineComment:"#"},brackets:[["[","]"],["<",">"],["(",")"]],autoClosingPairs:[{open:"[",close:"]"},{open:"<",close:">"},{open:"(",close:")"}],surroundingPairs:[{open:"[",close:"]"},{open:"<",close:">"},{open:"(",close:")"}]},p={defaultToken:"",tokenPostfix:".pla",brackets:[{open:"[",close:"]",token:"delimiter.square"},{open:"<",close:">",token:"delimiter.angle"},{open:"(",close:")",token:"delimiter.parenthesis"}],keywords:[".i",".o",".mv",".ilb",".ob",".label",".type",".phase",".pair",".symbolic",".symbolic-output",".kiss",".p",".e",".end"],comment:/#.*$/,identifier:/[a-zA-Z]+[a-zA-Z0-9_\-]*/,plaContent:/[01\-~\|]+/,tokenizer:{root:[{include:"@whitespace"},[/@comment/,"comment"],[/\.([a-zA-Z_\-]+)/,{cases:{"@eos":{token:"keyword.$1"},"@keywords":{cases:{".type":{token:"keyword.$1",next:"@type"},"@default":{token:"keyword.$1",next:"@keywordArg"}}},"@default":{token:"keyword.$1"}}}],[/@identifier/,"identifier"],[/@plaContent/,"string"]],whitespace:[[/[ \t\r\n]+/,""]],type:[{include:"@whitespace"},[/\w+/,{token:"type",next:"@pop"}]],keywordArg:[[/[ \t\r\n]+/,{cases:{"@eos":{token:"",next:"@pop"},"@default":""}}],[/@comment/,"comment","@pop"],[/[<>()\[\]]/,{cases:{"@eos":{token:"@brackets",next:"@pop"},"@default":"@brackets"}}],[/\-?\d+/,{cases:{"@eos":{token:"number",next:"@pop"},"@default":"number"}}],[/@identifier/,{cases:{"@eos":{token:"identifier",next:"@pop"},"@default":"identifier"}}],[/[;=]/,{cases:{"@eos":{token:"delimiter",next:"@pop"},"@default":"delimiter"}}]]}};return s(a)})()));