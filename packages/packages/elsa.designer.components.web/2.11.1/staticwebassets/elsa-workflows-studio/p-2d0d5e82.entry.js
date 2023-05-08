import{r as e,a as s,h as t,H as a,c as i,d as l,e as o}from"./p-ee0b9025.js";import{l as n}from"./p-6137089a.js";import{l as r,t as h,e as c}from"./p-fd4270fe.js";import{D as d}from"./p-3478a766.js";import{e as u}from"./p-93cac3a6.js";import"./p-c74b54ba.js";import{E as f}from"./p-d88cb309.js";import"./p-f1ec68ec.js";import"./p-a3b5bd35.js";import{g as p,a as m}from"./p-971980b1.js";import"./p-82db2ff5.js";import"./p-949334ec.js";import{G as w}from"./p-f7bc98b6.js";import{T as g}from"./p-821a7518.js";import{a as y}from"./p-7462b7bd.js";import{c as b}from"./p-2ee88bf6.js";import{t as v}from"./p-8675edd4.js";import{a as x,c as k}from"./p-ccd51ea4.js";import{f as j}from"./p-34c33cf9.js";import{p as C}from"./p-743d1a9d.js";import{p as W}from"./p-aae56f4d.js";import{a as P}from"./p-e77aabd2.js";import{A as D}from"./p-1b1f9628.js";import"./p-80de33dc.js";import"./p-fe704386.js";import"./p-83f217d4.js";import"./p-e0c1fede.js";const R=new RegExp(["(\\\\.)","(?:\\:(\\w+)(?:\\(((?:\\\\.|[^\\\\()])+)\\))?|\\(((?:\\\\.|[^\\\\()])+)\\))([+*?])?"].join("|"),"g"),E=e=>e.replace(/([.+*?=^!:${}()[\]|/\\])/g,"\\$1"),O=e=>e.replace(/([=!:$/()])/g,"\\$1"),_=e=>e&&e.sensitive?"":"i",I=(e,t,s)=>{for(var a=(s=s||{}).strict,i=!1!==s.end,o=E(s.delimiter||"/"),n=s.delimiters||"./",l=[].concat(s.endsWith||[]).map(E).concat("$").join("|"),r="",c=!1,h=0;h<e.length;h++){var u=e[h];if("string"==typeof u)r+=E(u),c=h===e.length-1&&n.indexOf(u[u.length-1])>-1;else{var d=E(u.prefix||""),f=u.repeat?"(?:"+u.pattern+")(?:"+d+"(?:"+u.pattern+"))*":u.pattern;t&&t.push(u),r+=u.optional?u.partial?d+"("+f+")?":"(?:"+d+"("+f+"))?":d+"("+f+")"}}return i?(a||(r+="(?:"+o+")?"),r+="$"===l?"$":"(?="+l+")"):(a||(r+="(?:"+o+"(?="+l+"))?"),c||(r+="(?="+o+"|"+l+")")),new RegExp("^"+r,_(s))},L=(e,t,s)=>e instanceof RegExp?((e,t)=>{if(!t)return e;var s=e.source.match(/\((?!\?)/g);if(s)for(var a=0;a<s.length;a++)t.push({name:a,prefix:null,delimiter:null,optional:!1,repeat:!1,partial:!1,pattern:null});return e})(e,t):Array.isArray(e)?((e,t,s)=>{for(var a=[],i=0;i<e.length;i++)a.push(L(e[i],t,s).source);return new RegExp("(?:"+a.join("|")+")",_(s))})(e,t,s):((e,t,s)=>I(((e,t)=>{for(var s,a=[],i=0,o=0,n="",l=t&&t.delimiter||"/",r=t&&t.delimiters||"./",c=!1;null!==(s=R.exec(e));){var h=s[0],u=s[1],d=s.index;if(n+=e.slice(o,d),o=d+h.length,u)n+=u[1],c=!0;else{var f="",p=e[o],m=s[2],g=s[3],y=s[4],w=s[5];if(!c&&n.length){var b=n.length-1;r.indexOf(n[b])>-1&&(f=n[b],n=n.slice(0,b))}n&&(a.push(n),n="",c=!1);var x=f||l,v=g||y;a.push({name:m||i++,prefix:f,delimiter:x,optional:"?"===w||"*"===w,repeat:"+"===w||"*"===w,partial:""!==f&&void 0!==p&&p!==f,pattern:v?O(v):"[^"+E(x)+"]+?"})}}return(n||o<e.length)&&a.push(n+e.substr(o)),a})(e,s),t,s))(e,t,s),M=(e,t)=>new RegExp("^"+t+"(\\/|\\?|#|$)","i").test(e),$=(e,t)=>M(e,t)?e.substr(t.length):e,S=e=>"/"===e.charAt(e.length-1)?e.slice(0,-1):e,T=e=>"/"===e.charAt(0)?e:"/"+e,A=e=>"/"===e.charAt(0)?e.substr(1):e,U=e=>{const{pathname:t,search:s,hash:a}=e;let i=t||"/";return s&&"?"!==s&&(i+="?"===s.charAt(0)?s:`?${s}`),a&&"#"!==a&&(i+="#"===a.charAt(0)?a:`#${a}`),i},H=e=>"/"===e.charAt(0),N=e=>Math.random().toString(36).substr(2,e),z=(e,t)=>{for(let s=t,a=s+1,i=e.length;a<i;s+=1,a+=1)e[s]=e[a];e.pop()},B=(e,t)=>{if(e===t)return!0;if(null==e||null==t)return!1;if(Array.isArray(e))return Array.isArray(t)&&e.length===t.length&&e.every(((e,s)=>B(e,t[s])));const s=typeof e;if(s!==typeof t)return!1;if("object"===s){const s=e.valueOf(),a=t.valueOf();if(s!==e||a!==t)return B(s,a);const i=Object.keys(e),o=Object.keys(t);return i.length===o.length&&i.every((s=>B(e[s],t[s])))}return!1},Y=(e,t,s,a)=>{let i;"string"==typeof e?(i=(e=>{let t=e||"/",s="",a="";const i=t.indexOf("#");-1!==i&&(a=t.substr(i),t=t.substr(0,i));const o=t.indexOf("?");return-1!==o&&(s=t.substr(o),t=t.substr(0,o)),{pathname:t,search:"?"===s?"":s,hash:"#"===a?"":a,query:{},key:""}})(e),void 0!==t&&(i.state=t)):(i=Object.assign({pathname:""},e),i.search&&"?"!==i.search.charAt(0)&&(i.search="?"+i.search),i.hash&&"#"!==i.hash.charAt(0)&&(i.hash="#"+i.hash),void 0!==t&&void 0===i.state&&(i.state=t));try{i.pathname=decodeURI(i.pathname)}catch(e){throw e instanceof URIError?new URIError('Pathname "'+i.pathname+'" could not be decoded. This is likely caused by an invalid percent-encoding.'):e}var o;return i.key=s,a?i.pathname?"/"!==i.pathname.charAt(0)&&(i.pathname=((e,t="")=>{let s,a=t&&t.split("/")||[],i=0;const o=e&&e.split("/")||[],n=e&&H(e),l=t&&H(t),r=n||l;if(e&&H(e)?a=o:o.length&&(a.pop(),a=a.concat(o)),!a.length)return"/";if(a.length){const e=a[a.length-1];s="."===e||".."===e||""===e}else s=!1;for(let e=a.length;e>=0;e--){const t=a[e];"."===t?z(a,e):".."===t?(z(a,e),i++):i&&(z(a,e),i--)}if(!r)for(;i--;i)a.unshift("..");!r||""===a[0]||a[0]&&H(a[0])||a.unshift("");let c=a.join("/");return s&&"/"!==c.substr(-1)&&(c+="/"),c})(i.pathname,a.pathname)):i.pathname=a.pathname:i.pathname||(i.pathname="/"),i.query=(o=i.search||"")?(/^[?#]/.test(o)?o.slice(1):o).split("&").reduce(((e,t)=>{let[s,a]=t.split("=");return e[s]=a?decodeURIComponent(a.replace(/\+/g," ")):"",e}),{}):{},i};let F=0;const J={},V=(e,t={})=>{"string"==typeof t&&(t={path:t});const{path:s="/",exact:a=!1,strict:i=!1}=t,{re:o,keys:n}=((e,t)=>{const s=`${t.end}${t.strict}`,a=J[s]||(J[s]={}),i=JSON.stringify(e);if(a[i])return a[i];const o=[],n={re:L(e,o,t),keys:o};return F<1e4&&(a[i]=n,F+=1),n})(s,{end:a,strict:i}),l=o.exec(e);if(!l)return null;const[r,...c]=l,h=e===r;return a&&!h?null:{path:s,url:"/"===s&&""===r?"/":r,isExact:h,params:n.reduce(((e,t,s)=>(e[t.name]=c[s],e)),{})}};let q=class{constructor(t){e(this,t),this.context={},this.renderer=()=>null}connectedCallback(){null!=this.subscribe&&(this.unsubscribe=this.subscribe(this.el,"context"))}disconnectedCallback(){null!=this.unsubscribe&&this.unsubscribe()}render(){return this.renderer(Object.assign({},this.context))}get el(){return s(this)}};const Q={en:{default:{Yes:"Yes",No:"No"}},"zh-CN":{default:{Yes:"是",No:"否"}},"nl-NL":{default:{Yes:"Ja",No:"Nee"}},"fa-IR":{default:{Yes:"بله",No:"خیر"}},"de-DE":{default:{Yes:"Ja",No:"Nein"}}};let G=class{constructor(t){e(this,t)}async show(e,t){return this.caption=e,this.message=t,await this.dialog.show(!0),new Promise(((e,t)=>{this.fulfill=e,this.reject=t}))}async hide(){await this.dialog.hide(!0)}async componentWillLoad(){this.i18next=await n(this.culture,Q)}async onDismissClick(){this.fulfill(!1),await this.hide()}async onAcceptClick(){this.fulfill(!0),this.fulfill=null,this.reject=null,await this.hide()}render(){const e=e=>this.i18next.t(e);return t(a,null,t("elsa-modal-dialog",{ref:e=>this.dialog=e},t("div",{slot:"content",class:"elsa-py-8 elsa-px-4"},t("div",{class:"hidden sm:elsa-block elsa-absolute elsa-top-0 elsa-right-0 elsa-pt-4 elsa-pr-4"},t("button",{type:"button",onClick:()=>this.onDismissClick(),class:"elsa-bg-white elsa-rounded-md elsa-text-gray-400 hover:elsa-text-gray-500 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:elsa-ring-blue-500"},t("span",{class:"elsa-sr-only"},"Close"),t("svg",{class:"elsa-h-6 elsa-w-6","x-description":"Heroicon name: outline/x",xmlns:"http://www.w3.org/2000/svg",fill:"none",viewBox:"0 0 24 24",stroke:"currentColor","aria-hidden":"true"},t("path",{"stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"2",d:"M6 18L18 6M6 6l12 12"})))),t("div",{class:"sm:elsa-flex sm:elsa-items-start"},t("div",{class:"elsa-mx-auto elsa-flex-shrink-0 elsa-flex elsa-items-center elsa-justify-center elsa-h-12 elsa-w-12 elsa-rounded-full elsa-bg-red-100 sm:elsa-mx-0 sm:elsa-h-10 sm:elsa-w-10"},t("svg",{class:"elsa-h-6 elsa-w-6 elsa-text-red-600","x-description":"Heroicon name: outline/exclamation",xmlns:"http://www.w3.org/2000/svg",fill:"none",viewBox:"0 0 24 24",stroke:"currentColor","aria-hidden":"true"},t("path",{"stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"2",d:"M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z"}))),t("div",{class:"elsa-mt-3 elsa-text-center sm:elsa-mt-0 sm:elsa-ml-4 sm:elsa-text-left"},t("h3",{class:"elsa-text-lg elsa-leading-6 elsa-font-medium elsa-text-gray-900",id:"modal-title"},this.caption),t("div",{class:"elsa-mt-2"},t("p",{class:"elsa-text-sm elsa-text-gray-500"},this.message))))),t("div",{slot:"buttons"},t("div",{class:"elsa-bg-gray-50 elsa-px-4 elsa-py-3 sm:elsa-px-6 sm:elsa-flex sm:elsa-flex-row-reverse"},t("button",{type:"button",onClick:()=>this.onAcceptClick(),class:"elsa-w-full elsa-inline-flex elsa-justify-center elsa-rounded-md elsa-border elsa-border-transparent elsa-shadow-sm elsa-px-4 elsa-py-2 elsa-bg-red-600 elsa-text-base elsa-font-medium elsa-text-white hover:elsa-bg-red-700 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:elsa-ring-red-500 sm:elsa-ml-3 sm:elsa-w-auto sm:elsa-text-sm"},e("Yes")),t("button",{type:"button",onClick:()=>this.onDismissClick(),class:"elsa-mt-3 elsa-w-full elsa-inline-flex elsa-justify-center elsa-rounded-md elsa-border elsa-border-gray-300 elsa-shadow-sm elsa-px-4 elsa-py-2 elsa-bg-white elsa-text-base elsa-font-medium elsa-text-gray-700 hover:elsa-text-gray-500 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:ring-indigo-500 sm:elsa-mt-0 sm:elsa-w-auto sm:elsa-text-sm"},e("No"))))))}},K=class{constructor(t){e(this,t),this.itemSelected=i(this,"itemSelected",7),this.btnClass=" elsa-w-full elsa-bg-white elsa-border elsa-border-gray-300 elsa-rounded-md elsa-shadow-sm elsa-px-4 elsa-py-2 elsa-inline-flex elsa-justify-center elsa-text-sm elsa-font-medium elsa-text-gray-700 hover:elsa-bg-gray-50 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:elsa-ring-blue-500",this.origin=d.TopLeft,this.items=[]}onWindowClicked(e){this.element.contains(e.target)||this.closeContextMenu()}closeContextMenu(){this.contextMenu&&r(this.contextMenu)}toggleMenu(){this.contextMenu&&h(this.contextMenu)}getOriginClass(){switch(this.origin){case d.TopLeft:return"elsa-left-0 elsa-origin-top-left";case d.TopRight:default:return"elsa-right-0 elsa-origin-top-right"}}async onItemClick(e,t){e.preventDefault(),this.itemSelected.emit(t),this.closeContextMenu()}render(){return t("div",{class:"elsa-relative",ref:e=>this.element=e},t("button",{onClick:()=>this.toggleMenu(),type:"button",class:this.btnClass,"aria-haspopup":"true","aria-expanded":"false"},this.renderIcon(),this.text,t("svg",{class:"elsa-ml-2.5 -elsa-elsa-mr-1.5 elsa-h-5 elsa-w-5 elsa-text-gray-400","x-description":"Heroicon name: chevron-down",xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 20 20",fill:"currentColor","aria-hidden":"true"},t("path",{"fill-rule":"evenodd",d:"M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z","clip-rule":"evenodd"}))),this.renderMenu())}renderMenu(){if(0==this.items.length)return;const e=this.getOriginClass();return t("div",{ref:e=>this.contextMenu=e,"data-transition-enter":"elsa-transition elsa-ease-out elsa-duration-100","data-transition-enter-start":"elsa-transform elsa-opacity-0 elsa-scale-95","data-transition-leave":"elsa-transition elsa-ease-in elsa-duration-75","data-transition-leave-start":"elsa-transform elsa-opacity-100 elsa-scale-100","data-transition-leave-end":"elsa-transform elsa-opacity-0 elsa-scale-95",class:`hidden ${e} elsa-z-10 elsa-absolute elsa-mt-2 elsa-w-56 elsa-rounded-md elsa-shadow-lg elsa-bg-white elsa-ring-1 elsa-ring-black elsa-ring-opacity-5`},t("div",{class:"elsa-py-1",role:"menu","aria-orientation":"vertical"},this.renderItems()))}renderItems(){return this.items.map((e=>{const s=e.isSelected?"elsa-bg-blue-600 hover:elsa-bg-blue-700 elsa-text-white":"hover:elsa-bg-gray-100 elsa-text-gray-700 hover:elsa-text-gray-900";return e.url?t("stencil-route-link",{onClick:()=>this.closeContextMenu(),url:e.url,anchorClass:`elsa-block elsa-px-4 elsa-py-2 elsa-text-sm ${s} elsa-cursor-pointer`,role:"menuitem"},e.text):t("a",{href:"#",onClick:t=>this.onItemClick(t,e),class:`elsa-block elsa-px-4 elsa-py-2 elsa-text-sm ${s}`,role:"menuitem"},e.text)}))}renderIcon(){if(this.icon)return this.icon}};K.style="";let X=class{constructor(t){e(this,t),this.shown=i(this,"shown",7),this.hidden=i(this,"hidden",7),this.handleDefaultClose=async()=>{await this.hide()}}render(){return this.renderModal()}async show(e=!0){this.showInternal(e)}async hide(e=!0){await u.emit(f.HideModalDialog),this.hideInternal(e)}showInternal(e){this.isVisible=!0,e||(this.overlay.style.opacity="1",this.modal.style.opacity="1"),c(this.overlay),c(this.modal).then(this.shown.emit)}hideInternal(e){e||(this.isVisible=!1),r(this.overlay),r(this.modal).then((()=>{this.isVisible=!1,this.hidden.emit()}))}async handleKeyDown(e){this.isVisible&&"Escape"===e.key&&await this.hide(!0)}renderModal(){return t(a,{class:{hidden:!this.isVisible,"elsa-block":!0}},t("div",{class:"elsa-fixed elsa-z-10 elsa-inset-0 elsa-overflow-y-auto"},t("div",{class:"elsa-flex elsa-items-end elsa-justify-center elsa-min-h-screen elsa-pt-4 elsa-px-4 elsa-pb-20 elsa-text-center sm:elsa-block sm:elsa-p-0"},t("div",{ref:e=>this.overlay=e,onClick:()=>this.hide(!0),"data-transition-enter":"elsa-ease-out elsa-duration-300","data-transition-enter-start":"elsa-opacity-0","data-transition-enter-end":"elsa-opacity-0","data-transition-leave":"elsa-ease-in elsa-duration-200","data-transition-leave-start":"elsa-opacity-0","data-transition-leave-end":"elsa-opacity-0",class:"hidden elsa-fixed elsa-inset-0 elsa-transition-opacity","aria-hidden":"true"},t("div",{class:"elsa-absolute elsa-inset-0 elsa-bg-gray-500 elsa-opacity-75"})),t("span",{class:"hidden sm:elsa-inline-block sm:elsa-align-middle sm:elsa-h-screen","aria-hidden":"true"}),t("div",{ref:e=>this.modal=e,"data-transition-enter":"elsa-ease-out elsa-duration-300","data-transition-enter-start":"elsa-opacity-0 elsa-translate-y-4 sm:elsa-translate-y-0 sm:elsa-scale-95","data-transition-enter-end":"elsa-opacity-0 elsa-translate-y-0 sm:elsa-scale-100","data-transition-leave":"elsa-ease-in elsa-duration-200","data-transition-leave-start":"elsa-opacity-0 elsa-translate-y-0 sm:elsa-scale-100","data-transition-leave-end":"elsa-opacity-0 elsa-translate-y-4 sm:elsa-translate-y-0 sm:elsa-scale-95",class:"hidden elsa-inline-block sm:elsa-align-top elsa-bg-white elsa-rounded-lg elsa-text-left elsa-overflow-visible elsa-shadow-xl elsa-transform elsa-transition-all sm:elsa-my-8 sm:elsa-align-top sm:elsa-max-w-4xl sm:elsa-w-full",role:"dialog","aria-modal":"true","aria-labelledby":"modal-headline"},t("div",{class:"modal-content"},t("slot",{name:"content"})),t("slot",{name:"buttons"},t("div",{class:"elsa-bg-gray-50 elsa-px-4 elsa-py-3 sm:elsa-px-6 sm:elsa-flex sm:elsa-flex-row-reverse"},t("button",{type:"button",onClick:this.handleDefaultClose,class:"elsa-mt-3 elsa-w-full elsa-inline-flex elsa-justify-center elsa-rounded-md elsa-border elsa-border-gray-300 elsa-shadow-sm elsa-px-4 elsa-py-2 elsa-bg-white elsa-text-base elsa-font-medium elsa-text-gray-700 hover:elsa-bg-gray-50 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:elsa-ring-blue-500 sm:elsa-mt-0 sm:elsa-ml-3 sm:elsa-w-auto sm:elsa-text-sm"},"Close")))))))}};const Z={en:{default:{WorkflowDefinitions:"Workflow Definitions",WorkflowInstances:"Workflow Instances",WorkflowRegistry:"Workflow Registry",WebhookDefinitions:"Webhook Definitions"}},"zh-CN":{default:{WorkflowDefinitions:"工作流定义",WorkflowInstances:"工作流实例",WorkflowRegistry:"工作流程注册表",WebhookDefinitions:"Webhook定义"}},"nl-NL":{default:{WorkflowDefinitions:"Workflow Definities",WorkflowInstances:"Workflows",WorkflowRegistry:"Workflow Register",WebhookDefinitions:"Webhook Definities"}},"fa-IR":{default:{WorkflowDefinitions:"فرآیندها",WorkflowInstances:"فرآیندهای اجرا شده",WorkflowRegistry:"Workflow Registry",WebhookDefinitions:"مشخصات Webhookها"}},"es-ES":{default:{WorkflowDefinitions:"Definiciones de flujos",WorkflowInstances:"Ejecuciones de flujos",WorkflowRegistry:"Registro de flujos",WebhookDefinitions:"Definiciones de webhooks"},menuItems:{"workflow-definitions":"Definiciones de flujos","workflow-instances":"Ejecuciones de flujos","workflow-registry":"Registro de flujos"}},"de-DE":{default:{WorkflowDefinitions:"Ablaufdefinitionen",WorkflowInstances:"Ablaufinstanzen",WorkflowRegistry:"Ablaufverzeichnis",WebhookDefinitions:"Webhook Definitionen"},menuItems:{"workflow-definitions":"Ablaufdefinitionen","workflow-instances":"Ablaufinstanzen","workflow-registry":"Ablaufverzeichnis"}}};let ee=class{constructor(t){e(this,t),this.basePath="",this.dashboardMenu={data:{menuItems:[["workflow-definitions","Workflow Definitions"],["workflow-instances","Workflow Instances"],["workflow-registry","Workflow Registry"]],routes:[["","elsa-studio-home",!0],["workflow-registry","elsa-studio-workflow-registry",!0],["workflow-registry/:id","elsa-studio-workflow-blueprint-view"],["workflow-definitions","elsa-studio-workflow-definitions-list",!0],["workflow-definitions/:id","elsa-studio-workflow-definitions-edit"],["workflow-instances","elsa-studio-workflow-instances-list",!0],["workflow-instances/:id","elsa-studio-workflow-instances-view"],["oauth2-authorized","elsa-oauth2-authorized",!0]]}}}async componentWillLoad(){this.i18next=await n(this.culture,Z),await u.emit(f.Dashboard.Appearing,this,this.dashboardMenu)}render(){const e=l("./assets/logo.png"),s=this.basePath||"",a=w(this.i18next);let i=(null!=this.dashboardMenu.data?this.dashboardMenu.data.menuItems:[]).map((([e,t])=>this.i18next.exists(`menuItems:${e}`)?[e,this.i18next.t(`menuItems:${e}`)]:[e,t])),o=null!=this.dashboardMenu.data?this.dashboardMenu.data.routes:[];return t("div",{class:"elsa-h-screen elsa-bg-gray-100"},t("nav",{class:"elsa-bg-gray-800"},t("div",{class:"elsa-px-4 sm:elsa-px-6 lg:elsa-px-8"},t("div",{class:"elsa-flex elsa-items-center elsa-justify-between elsa-h-16"},t("div",{class:"elsa-flex elsa-items-center"},t("div",{class:"elsa-flex-shrink-0"},t("stencil-route-link",{url:`${s}/`},t("img",{class:"elsa-h-8 elsa-w-8",src:e,alt:"Workflow"}))),t("div",{class:"hidden md:elsa-block"},t("div",{class:"elsa-ml-10 elsa-flex elsa-items-baseline elsa-space-x-4"},i.map((e=>((e,s)=>t("stencil-route-link",{url:`${s}/${e[0]}`,anchorClass:"elsa-text-gray-300 hover:elsa-bg-gray-700 hover:elsa-text-white elsa-px-3 elsa-py-2 elsa-rounded-md elsa-text-sm elsa-font-medium",activeClass:"elsa-text-white elsa-bg-gray-900"},t(a,{label:`${e[1]}`})))(e,s)))))),t("elsa-user-context-menu",null)))),t("main",null,t("stencil-router",null,t("stencil-route-switch",{scrollTopOffset:0},o.map((e=>((e,s)=>t("stencil-route",{url:`${s}/${e[0]}`,component:`${e[1]}`,exact:e[2]}))(e,s)))))))}static get assetsDirs(){return["assets"]}};g.injectProps(ee,["culture","basePath"]);let se=class{constructor(t){e(this,t),this.initializing=i(this,"initializing",7),this.initialized=i(this,"initialized",7),this.basePath="",this.useX6Graphs=!1,this.onShowConfirmDialog=e=>e.promise=this.confirmDialog.show(e.caption,e.message),this.onHideConfirmDialog=async()=>await this.confirmDialog.hide(),this.onShowToastNotification=async e=>await this.toastNotificationElement.show(e),this.onHideToastNotification=async()=>await this.toastNotificationElement.hide()}async addPlugins(e){C.registerPlugins(e)}async addPlugin(e){C.registerPlugin(e)}workflowChangedHandler(e){u.emit(f.WorkflowModelChanged,this,e.detail)}connectedCallback(){u.on(f.ShowConfirmDialog,this.onShowConfirmDialog),u.on(f.HideConfirmDialog,this.onHideConfirmDialog),u.on(f.ShowToastNotification,this.onShowToastNotification),u.on(f.HideToastNotification,this.onHideToastNotification)}disconnectedCallback(){u.detach(f.ShowConfirmDialog,this.onShowConfirmDialog),u.detach(f.HideConfirmDialog,this.onHideConfirmDialog),u.detach(f.ShowToastNotification,this.onShowToastNotification),u.detach(f.HideToastNotification,this.onHideToastNotification)}async componentWillLoad(){P.useX6Graphs=this.useX6Graphs;const e=()=>x(this.serverUrl);this.config&&await fetch(`${document.location.origin}/${this.config}`).then((e=>{if(!e.ok)throw new Error("HTTP error "+e.status);return e.json()})).then((e=>{this.featuresConfig=e})).catch((e=>{console.error(e)}));const t=this.elsaStudio={serverUrl:this.serverUrl,basePath:this.basePath,features:this.featuresConfig,serverFeatures:[],serverVersion:null,eventBus:u,pluginManager:C,propertyDisplayManager:W,activityIconProvider:y,confirmDialogService:b,toastNotificationService:v,elsaClientFactory:e,httpClientFactory:()=>k(this.serverUrl),getOrCreateProperty:p,htmlToElement:m};this.initializing.emit(t),C.initialize(t),await u.emit(f.Root.Initializing),W.initialize(t),j.initialize(t);const s=await e();t.serverFeatures=await s.featuresApi.list(),t.serverVersion=await s.versionApi.get()}async componentDidLoad(){this.initialized.emit(this.elsaStudio),await u.emit(f.Root.Initialized)}render(){return t(g.Provider,{state:{serverUrl:this.serverUrl,basePath:this.basePath,serverFeatures:this.elsaStudio.serverFeatures,serverVersion:this.elsaStudio.serverVersion,culture:this.culture,monacoLibPath:this.monacoLibPath}},t("slot",null),t("elsa-confirm-dialog",{ref:e=>this.confirmDialog=e,culture:this.culture}),t("elsa-toast-notification",{ref:e=>this.toastNotificationElement=e}))}},te=class{constructor(t){e(this,t),this.isVisible=!1}async show(e){this.isVisible=!0,c(this.toast),e.autoCloseIn&&setTimeout((async()=>await this.hide()),e.autoCloseIn),this.title=e.title,this.message=e.message}async hide(){r(this.toast).then((()=>this.isVisible=!1))}render(){return this.renderToast()}renderToast(){return t(a,{class:{hidden:!this.isVisible,"elsa-block":!0}},t("div",{class:"elsa-fixed elsa-inset-0 elsa-z-20 elsa-flex elsa-items-end elsa-justify-center elsa-px-4 elsa-py-6 elsa-pointer-events-none sm:elsa-p-6 sm:elsa-items-start sm:elsa-justify-end"},t("div",{ref:e=>this.toast=e,"data-transition-enter":"elsa-transform elsa-ease-out elsa-duration-300 elsa-transition","data-transition-enter-start":"elsa-translate-y-2 elsa-opacity-0 sm:elsa-translate-y-0 sm:elsa-translate-x-2","data-transition-enter-end":"elsa-translate-y-0 elsa-opacity-100 sm:elsa-translate-x-0","data-transition-leave":"elsa-transition elsa-ease-in elsa-duration-100","data-transition-leave-start":"elsa-opacity-0","data-transition-leave-end":"elsa-opacity-0",class:"elsa-max-w-sm elsa-w-full elsa-bg-white elsa-shadow-lg elsa-rounded-lg elsa-pointer-events-auto elsa-ring-1 elsa-ring-black elsa-ring-opacity-5 elsa-overflow-hidden"},t("div",{class:"elsa-p-4"},t("div",{class:"elsa-flex elsa-items-start"},t("div",{class:"elsa-flex-shrink-0"},t("svg",{class:"elsa-h-6 elsa-w-6 elsa-text-green-400",fill:"none",viewBox:"0 0 24 24",stroke:"currentColor","aria-hidden":"true"},t("path",{"stroke-linecap":"round","stroke-linejoin":"round","stroke-width":"2",d:"M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"}))),t("div",{class:"elsa-ml-3 elsa-w-0 elsa-flex-1 elsa-pt-0.5"},this.renderTitle(),t("p",{class:"elsa-mt-1 elsa-text-sm elsa-text-gray-500"},this.message)),t("div",{class:"elsa-ml-4 elsa-flex-shrink-0 elsa-flex"},t("button",{class:"elsa-bg-white elsa-rounded-md elsa-inline-flex elsa-text-gray-400 hover:elsa-text-gray-500 focus:elsa-outline-none focus:elsa-ring-2 focus:elsa-ring-offset-2 focus:elsa-ring-blue-500"},t("span",{class:"elsa-sr-only"},"Close"),t("svg",{class:"elsa-h-5 elsa-w-5","x-description":"Heroicon name: solid/x",xmlns:"http://www.w3.org/2000/svg",viewBox:"0 0 20 20",fill:"currentColor","aria-hidden":"true"},t("path",{"fill-rule":"evenodd",d:"M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z","clip-rule":"evenodd"})))))))))}renderTitle(){if(this.title&&0!=this.title.length)return t("p",{class:"elsa-text-sm elsa-font-medium elsa-text-gray-900"},this.title)}},ae=class{constructor(t){e(this,t),this.userDetail=null,this.logoutStrategy={OpenIdConnect:function(){window.location.href="v1/ElsaAuthentication/logout"},ServerManagedCookie:function(){window.location.href="v1/ElsaAuthentication/logout"},JwtBearerToken:""}}async componentWillRender(){try{this.userDetail=await await(await x(this.serverUrl)).authenticationApi.getUserDetails(),this.authenticationConfguration=await await(await x(this.serverUrl)).authenticationApi.getAuthenticationConfguration()}catch(e){this.userDetail=null}}async menuItemSelected(e){"logout"==e.value&&this.authenticationConfguration.authenticationStyles.forEach((e=>{this.logoutStrategy[e]()}))}render(){if(null==this.userDetail)return"";const e=[{text:"logout",value:"logout"}].map((e=>({text:e.text,isSelected:!1,value:e.value})));return t("elsa-dropdown-button",{text:this.userDetail.name,items:e,btnClass:"elsa-bg-gray-800 elsa-text-gray-300 elsa-w-full   elsa-shadow-sm elsa-px-4 elsa-py-2 elsa-inline-flex elsa-justify-center elsa-text-sm elsa-font-medium",origin:d.TopRight,onItemSelected:e=>this.menuItemSelected(e.detail)})}};g.injectProps(ae,["serverUrl"]);let ie=class{constructor(t){e(this,t),this.group=null,this.match=null,this.componentProps={},this.exact=!1,this.scrollOnNextRender=!1,this.previousMatch=null}computeMatch(e){const t=null!=this.group||null!=this.el.parentElement&&"stencil-route-switch"===this.el.parentElement.tagName.toLowerCase();if(e&&!t)return this.previousMatch=this.match,this.match=V(e.pathname,{path:this.url,exact:this.exact,strict:!0})}async loadCompleted(){let e={};var t,s;this.history&&this.history.location.hash?e={scrollToId:this.history.location.hash.substr(1)}:this.scrollTopOffset&&(e={scrollTopOffset:this.scrollTopOffset}),"function"==typeof this.componentUpdated?this.componentUpdated(e):!this.match||(s=this.previousMatch,null==(t=this.match)&&null==s||null!=s&&t&&s&&t.path===s.path&&t.url===s.url&&B(t.params,s.params))||!this.routeViewsUpdated||this.routeViewsUpdated(e)}async componentDidUpdate(){await this.loadCompleted()}async componentDidLoad(){await this.loadCompleted()}render(){if(!this.match||!this.history)return null;const e=Object.assign({},this.componentProps,{history:this.history,match:this.match});return this.routeRender?this.routeRender(Object.assign({},e,{component:this.component})):this.component?t(this.component,Object.assign({},e)):void 0}get el(){return s(this)}static get watchers(){return{location:["computeMatch"]}}};D.injectProps(ie,["location","history","historyType","routeViewsUpdated"]),ie.style="";const le=(e,t,s)=>s(e.confirm(t)),oe=(e,t)=>{const s=e[t],a="__storage_test__";try{return s.setItem(a,a),s.removeItem(a),!0}catch(e){return e instanceof DOMException&&(22===e.code||1014===e.code||"QuotaExceededError"===e.name||"NS_ERROR_DOM_QUOTA_REACHED"===e.name)&&0!==s.length}};let ne=class{constructor(t){e(this,t),this.unsubscribe=()=>{},this.activeClass="link-active",this.exact=!1,this.strict=!0,this.custom="a",this.match=null}componentWillLoad(){this.computeMatch()}computeMatch(){this.location&&(this.match=V(this.location.pathname,{path:this.urlMatch||this.url,exact:this.exact,strict:this.strict}))}handleClick(e){var t,s,a;if(!((t=e).metaKey||t.altKey||t.ctrlKey||t.shiftKey)&&this.history&&this.url&&this.root)return e.preventDefault(),this.history.push((a=this.root,"/"==(s=this.url).charAt(0)&&"/"==a.charAt(a.length-1)?a.slice(0,a.length-1)+s:a+s))}render(){let e={class:{[this.activeClass]:null!==this.match},onClick:this.handleClick.bind(this)};return this.anchorClass&&(e.class[this.anchorClass]=!0),"a"===this.custom&&(e=Object.assign({},e,{href:this.url,title:this.anchorTitle,role:this.anchorRole,tabindex:this.anchorTabIndex,"aria-haspopup":this.ariaHaspopup,id:this.anchorId,"aria-posinset":this.ariaPosinset,"aria-setsize":this.ariaSetsize,"aria-label":this.ariaLabel})),t(this.custom,Object.assign({},e),t("slot",null))}get el(){return s(this)}static get watchers(){return{location:["computeMatch"]}}};D.injectProps(ne,["history","location","root"]);const re=e=>"STENCIL-ROUTE"===e.tagName;let he=class{constructor(t){e(this,t),this.group=((1e17*Math.random()).toString().match(/.{4}/g)||[]).join("-"),this.subscribers=[],this.queue=o(this,"queue")}componentWillLoad(){null!=this.location&&this.regenerateSubscribers(this.location)}async regenerateSubscribers(e){if(null==e)return;let t=-1;if(this.subscribers=Array.prototype.slice.call(this.el.children).filter(re).map(((s,a)=>{const i=V(e.pathname,{path:s.url,exact:s.exact,strict:!0});return i&&-1===t&&(t=a),{el:s,match:i}})),-1===t)return;if(this.activeIndex===t)return void(this.subscribers[t].el.match=this.subscribers[t].match);this.activeIndex=t;const s=this.subscribers[this.activeIndex];this.scrollTopOffset&&(s.el.scrollTopOffset=this.scrollTopOffset),s.el.group=this.group,s.el.match=s.match,s.el.componentUpdated=e=>{this.queue.write((()=>{this.subscribers.forEach(((e,t)=>{if(e.el.componentUpdated=void 0,t===this.activeIndex)return e.el.style.display="";this.scrollTopOffset&&(e.el.scrollTopOffset=this.scrollTopOffset),e.el.group=this.group,e.el.match=null,e.el.style.display="none"}))})),this.routeViewsUpdated&&this.routeViewsUpdated(Object.assign({scrollTopOffset:this.scrollTopOffset},e))}}render(){return t("slot",null)}get el(){return s(this)}static get watchers(){return{location:["regenerateSubscribers"]}}};D.injectProps(he,["location","routeViewsUpdated"]);const ce=(e,...t)=>{e||console.warn(...t)},de=()=>{let e,t=[];return{setPrompt:t=>(ce(null==e,"A history supports only one prompt at a time"),e=t,()=>{e===t&&(e=null)}),confirmTransitionTo:(t,s,a,i)=>{if(null!=e){const o="function"==typeof e?e(t,s):e;"string"==typeof o?"function"==typeof a?a(o,i):(ce(!1,"A history needs a getUserConfirmation function in order to use a prompt message"),i(!0)):i(!1!==o)}else i(!0)},appendListener:e=>{let s=!0;const a=(...t)=>{s&&e(...t)};return t.push(a),()=>{s=!1,t=t.filter((e=>e!==a))}},notifyListeners:(...e)=>{t.forEach((t=>t(...e)))}}},ue=(e,t="scrollPositions")=>{let s=new Map;const a=(t,a)=>{if(s.set(t,a),oe(e,"sessionStorage")){const t=[];s.forEach(((e,s)=>{t.push([s,e])})),e.sessionStorage.setItem("scrollPositions",JSON.stringify(t))}};if(oe(e,"sessionStorage")){const a=e.sessionStorage.getItem(t);s=a?new Map(JSON.parse(a)):s}return"scrollRestoration"in e.history&&(history.scrollRestoration="manual"),{set:a,get:e=>s.get(e),has:e=>s.has(e),capture:t=>{a(t,[e.scrollX,e.scrollY])}}},fe={hashbang:{encodePath:e=>"!"===e.charAt(0)?e:"!/"+A(e),decodePath:e=>"!"===e.charAt(0)?e.substr(1):e},noslash:{encodePath:A,decodePath:T},slash:{encodePath:T,decodePath:T}},pe=(e,t)=>{const s=0==e.pathname.indexOf(t)?"/"+e.pathname.slice(t.length):e.pathname;return Object.assign({},e,{pathname:s})},me={browser:(e,t={})=>{let s=!1;const a=e.history,i=e.location,o=e.navigator,n=(e=>{const t=e.navigator.userAgent;return(-1===t.indexOf("Android 2.")&&-1===t.indexOf("Android 4.0")||-1===t.indexOf("Mobile Safari")||-1!==t.indexOf("Chrome")||-1!==t.indexOf("Windows Phone"))&&e.history&&"pushState"in e.history})(e),l=!(-1===o.userAgent.indexOf("Trident")),r=ue(e),c=null!=t.forceRefresh&&t.forceRefresh,h=null!=t.getUserConfirmation?t.getUserConfirmation:le,u=null!=t.keyLength?t.keyLength:6,d=t.basename?S(T(t.basename)):"",f=()=>{try{return e.history.state||{}}catch(e){return{}}},p=e=>{e=e||{};const{key:t,state:s}=e,{pathname:a,search:o,hash:n}=i;let l=a+o+n;return ce(!d||M(l,d),'You are attempting to use a basename on a page whose URL path does not begin with the basename. Expected path "'+l+'" to begin with "'+d+'".'),d&&(l=$(l,d)),Y(l,s,t||N(u))},m=de(),g=e=>{r.capture(I.location.key),Object.assign(I,e),I.location.scrollPosition=r.get(I.location.key),I.length=a.length,m.notifyListeners(I.location,I.action)},y=e=>{((e,t)=>void 0===t.state&&-1===e.userAgent.indexOf("CriOS"))(o,e)||b(p(e.state))},w=()=>{b(p(f()))},b=e=>{if(s)s=!1,g();else{const t="POP";m.confirmTransitionTo(e,t,h,(s=>{s?g({action:t,location:e}):x(e)}))}},x=e=>{let t=k.indexOf(I.location.key),a=k.indexOf(e.key);-1===t&&(t=0),-1===a&&(a=0);const i=t-a;i&&(s=!0,D(i))},v=p(f());let k=[v.key],C=0,j=!1;const O=e=>d+U(e),D=e=>{a.go(e)},P=t=>{C+=t,1===C?(e.addEventListener("popstate",y),l&&e.addEventListener("hashchange",w)):0===C&&(e.removeEventListener("popstate",y),l&&e.removeEventListener("hashchange",w))},I={length:a.length,action:"POP",location:v,createHref:O,push:(e,t)=>{ce(!("object"==typeof e&&void 0!==e.state&&void 0!==t),"You should avoid providing a 2nd state argument to push when the 1st argument is a location-like object that already has state; it is ignored");const s="PUSH",o=Y(e,t,N(u),I.location);m.confirmTransitionTo(o,s,h,(e=>{if(!e)return;const t=O(o),{key:l,state:r}=o;if(n)if(a.pushState({key:l,state:r},"",t),c)i.href=t;else{const e=k.indexOf(I.location.key),t=k.slice(0,-1===e?0:e+1);t.push(o.key),k=t,g({action:s,location:o})}else ce(void 0===r,"Browser history cannot push state in browsers that do not support HTML5 history"),i.href=t}))},replace:(e,t)=>{ce(!("object"==typeof e&&void 0!==e.state&&void 0!==t),"You should avoid providing a 2nd state argument to replace when the 1st argument is a location-like object that already has state; it is ignored");const s="REPLACE",o=Y(e,t,N(u),I.location);m.confirmTransitionTo(o,s,h,(e=>{if(!e)return;const t=O(o),{key:l,state:r}=o;if(n)if(a.replaceState({key:l,state:r},"",t),c)i.replace(t);else{const e=k.indexOf(I.location.key);-1!==e&&(k[e]=o.key),g({action:s,location:o})}else ce(void 0===r,"Browser history cannot replace state in browsers that do not support HTML5 history"),i.replace(t)}))},go:D,goBack:()=>D(-1),goForward:()=>D(1),block:(e="")=>{const t=m.setPrompt(e);return j||(P(1),j=!0),()=>(j&&(j=!1,P(-1)),t())},listen:e=>{const t=m.appendListener(e);return P(1),()=>{P(-1),t()}},win:e};return I},hash:(e,t={})=>{let s=!1,a=null,i=0,o=!1;const n=e.location,l=e.history,r=-1===e.navigator.userAgent.indexOf("Firefox"),c=null!=t.keyLength?t.keyLength:6,{getUserConfirmation:h=le,hashType:u="slash"}=t,d=t.basename?S(T(t.basename)):"",{encodePath:f,decodePath:p}=fe[u],m=()=>{const e=n.href,t=e.indexOf("#");return-1===t?"":e.substring(t+1)},g=e=>{const t=n.href.indexOf("#");n.replace(n.href.slice(0,t>=0?t:0)+"#"+e)},y=()=>{let e=p(m());return ce(!d||M(e,d),'You are attempting to use a basename on a page whose URL path does not begin with the basename. Expected path "'+e+'" to begin with "'+d+'".'),d&&(e=$(e,d)),Y(e,void 0,N(c))},w=de(),b=e=>{Object.assign(A,e),A.length=l.length,w.notifyListeners(A.location,A.action)},x=()=>{const e=m(),t=f(e);if(e!==t)g(t);else{const e=y(),t=A.location;if(!s&&(i=t).pathname===(o=e).pathname&&i.search===o.search&&i.hash===o.hash&&i.key===o.key&&B(i.state,o.state))return;if(a===U(e))return;a=null,v(e)}var i,o},v=e=>{if(s)s=!1,b();else{const t="POP";w.confirmTransitionTo(e,t,h,(s=>{s?b({action:t,location:e}):k(e)}))}},k=e=>{let t=D.lastIndexOf(U(A.location)),a=D.lastIndexOf(U(e));-1===t&&(t=0),-1===a&&(a=0);const i=t-a;i&&(s=!0,P(i))},C=m(),j=f(C);C!==j&&g(j);const O=y();let D=[U(O)];const P=e=>{ce(r,"Hash history go(n) causes a full page reload in this browser"),l.go(e)},I=(e,t)=>{i+=t,1===i?e.addEventListener("hashchange",x):0===i&&e.removeEventListener("hashchange",x)},A={length:l.length,action:"POP",location:O,createHref:e=>"#"+f(d+U(e)),push:(e,t)=>{ce(void 0===t,"Hash history cannot push state; it is ignored");const s="PUSH",i=Y(e,void 0,N(c),A.location);w.confirmTransitionTo(i,s,h,(e=>{if(!e)return;const t=U(i),o=f(d+t);if(m()!==o){a=t,(e=>{n.hash=e})(o);const e=D.lastIndexOf(U(A.location)),l=D.slice(0,-1===e?0:e+1);l.push(t),D=l,b({action:s,location:i})}else ce(!1,"Hash history cannot PUSH the same path; a new entry will not be added to the history stack"),b()}))},replace:(e,t)=>{ce(void 0===t,"Hash history cannot replace state; it is ignored");const s="REPLACE",i=Y(e,void 0,N(c),A.location);w.confirmTransitionTo(i,s,h,(e=>{if(!e)return;const t=U(i),o=f(d+t);m()!==o&&(a=t,g(o));const n=D.indexOf(U(A.location));-1!==n&&(D[n]=t),b({action:s,location:i})}))},go:P,goBack:()=>P(-1),goForward:()=>P(1),block:(t="")=>{const s=w.setPrompt(t);return o||(I(e,1),o=!0),()=>(o&&(o=!1,I(e,-1)),s())},listen:t=>{const s=w.appendListener(t);return I(e,1),()=>{I(e,-1),s()}},win:e};return A}};let we=class{constructor(t){e(this,t),this.root="/",this.historyType="browser",this.titleSuffix="",this.routeViewsUpdated=(e={})=>{if(this.history&&e.scrollToId&&"browser"===this.historyType){const t=this.history.win.document.getElementById(e.scrollToId);if(t)return t.scrollIntoView()}this.scrollTo(e.scrollTopOffset||this.scrollTopOffset)},this.isServer=o(this,"isServer"),this.queue=o(this,"queue")}componentWillLoad(){this.history=me[this.historyType](this.el.ownerDocument.defaultView),this.history.listen((e=>{e=pe(e,this.root),this.location=e})),this.location=pe(this.history.location,this.root)}scrollTo(e){const t=this.history;if(null!=e&&!this.isServer&&t)return"POP"===t.action&&Array.isArray(t.location.scrollPosition)?this.queue.write((()=>{t&&t.location&&Array.isArray(t.location.scrollPosition)&&t.win.scrollTo(t.location.scrollPosition[0],t.location.scrollPosition[1])})):this.queue.write((()=>{t.win.scrollTo(0,e)}))}render(){if(this.location&&this.history)return t(D.Provider,{state:{historyType:this.historyType,location:this.location,titleSuffix:this.titleSuffix,root:this.root,history:this.history,routeViewsUpdated:this.routeViewsUpdated}},t("slot",null))}get el(){return s(this)}};export{q as context_consumer,G as elsa_confirm_dialog,K as elsa_dropdown_button,X as elsa_modal_dialog,ee as elsa_studio_dashboard,se as elsa_studio_root,te as elsa_toast_notification,ae as elsa_user_context_menu,ie as stencil_route,ne as stencil_route_link,he as stencil_route_switch,we as stencil_router};