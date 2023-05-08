!function(t){var e={};function n(r){if(e[r])return e[r].exports;var i=e[r]={i:r,l:!1,exports:{}};return t[r].call(i.exports,i,i.exports,n),i.l=!0,i.exports}n.m=t,n.c=e,n.d=function(t,e,r){n.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:r})},n.r=function(t){"undefined"!=typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},n.t=function(t,e){if(1&e&&(t=n(t)),8&e)return t;if(4&e&&"object"==typeof t&&t&&t.__esModule)return t;var r=Object.create(null);if(n.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var i in t)n.d(r,i,function(e){return t[e]}.bind(null,i));return r},n.n=function(t){var e=t&&t.__esModule?function(){return t.default}:function(){return t};return n.d(e,"a",e),e},n.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},n.p="",n(n.s=7)}([function(t,e,n){n.d(e,"f",(function(){return r})),n.d(e,"c",(function(){return s})),n.d(e,"d",(function(){return a})),n.d(e,"e",(function(){return c})),n.d(e,"b",(function(){return u})),n.d(e,"a",(function(){return l}));const r=t=>""===t||!!t,i=t=>t instanceof Date&&!isNaN(t.getTime()),o=/^\d{4}-\d{2}-\d{2}/,s=t=>{if(i(t))return t;if("string"==typeof t){const e=new Date(t);if(o.test(String(t))&&i(e))return e}},a=(t,e)=>{if("string"==typeof t)try{return JSON.parse(t)}catch(t){}return e},c=t=>{const e=Number(t);if(!isNaN(e))return e},u=(t,e)=>{const n=document.createElement(t);return Object.entries(e).forEach((([t,e])=>{n[t]=e})),n.connectedCallback(),n.textContent},l=t=>t.map((t=>t.toLowerCase()))},,function(t,e,n){n.d(e,"a",(function(){return i}));const r=["initialized","loaded","languageChanged"];class i extends HTMLElement{constructor(t){super(),this._observedAttributes=[],this._initialized=!1,this._props={},this._i18next=window.i18next;const e=t.reduce(((t,e)=>{const n=e.toLowerCase();return n!==e&&(t[n]=e),t}),{});this._observedAttributes=t,this._attrMap=t=>e[t]||t}set i18next(t){this._i18next!==t&&(this._disconnect(),this._i18next=t,this._connect())}static get observedAttributes(){return[]}connectedCallback(){this._assignProps(),this._disconnect(),this._connect(),this._initialized=!0,this._render()}disconnectedCallback(){this._disconnect()}attributeChangedCallback(t,e,n){e!==n&&(this._properties(this._attrMap(t),n),window.requestAnimationFrame((()=>{this._render()})))}_assignProps(){Array.from(this.attributes).forEach((t=>this._properties(this._attrMap(t.name),t.value))),this._observedAttributes.forEach((t=>{void 0!==this[t]&&this._properties(t,this[t]),Object.defineProperty(this,t,{get(){return this._props[t]},set(e){this.attributeChangedCallback(t,this._props[t],e)},configurable:!0,enumerable:!0})}))}_connect(){this._i18next&&(this._off=r.map((t=>{const e=()=>{window.requestAnimationFrame((()=>{this._assignProps(),this._render()}))};return this._i18next.on(t,e),()=>this._i18next.off(t,e)})))}_disconnect(){this._off&&this._off.forEach((t=>t()))}_languages(t){const e=this._i18next&&this._i18next.languages||navigator.languages;return[].concat(t,e).filter(Boolean)}_properties(t,e){}_render(){}}},function(t,e,n){n.r(e),n.d(e,"IntlMessage",(function(){return s})),n.d(e,"intlMessage",(function(){return a}));var r=n(2),i=n(0);const o=["key","label","count","context","lng","ns","options","value","dangerous"];class s extends r.a{constructor(){super(o),this._props={}}static get observedAttributes(){return Object(i.a)(o)}_properties(t,e){if("dangerous"===t)this._props.interpolation={escapeValue:!Object(i.f)(e)};else{const n=Object(i.c)(e)||Object(i.d)(e)||e;"options"===t&&"object"==typeof n?this._props=Object.assign(Object.assign({},this._props),n):this._props[t]=n}}_render(){if(this._initialized){const t=this._props,{label:e,key:n}=t,r=function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]])}return n}(t,["label","key"]),i=this._i18next.t(e||n,r);i&&(this.innerHTML=i)}}}function a(t={}){return Object(i.b)("intl-message",t)}customElements.define("intl-message",s)},function(t,e,n){n.r(e),n.d(e,"IntlDatetime",(function(){return u})),n.d(e,"intlDatetime",(function(){return l}));var r=n(2),i=n(0),o=function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]])}return n};const s=["value","lng","options","date","time","weekday","era","year","month","day","hour","minute","second","hour12","hourCycle","timeZone","timeZoneName","localeMatcher","formatMatcher","numberingSystem","calendar"],a={year:"numeric",month:"numeric",day:"numeric"},c={hour:"numeric",minute:"numeric",second:"numeric"};class u extends r.a{constructor(){super(s)}static get observedAttributes(){return Object(i.a)(s)}_properties(t,e){const{_props:n}=this;switch(t){case"value":n[t]=Object(i.c)(e);break;case"date":Object(i.f)(e)&&(this._props=Object.assign(n,a));break;case"time":if(Object(i.f)(e))this._props=Object.assign(n,c,{hour12:n.hour12||!1});else{const t=o(n,["hour","minute","second"]);this._props=t}break;case"hour12":n[t]=Object(i.f)(e);break;case"options":this._props=Object.assign(n,Object(i.d)(e,e));break;default:n[t]=Object(i.d)(e,e)}}_render(){if(this._initialized){const t=this._props,{value:e,lng:n}=t,r=o(t,["value","lng"]),i=e||new Date,s=this._languages(n);try{this.textContent=new Intl.DateTimeFormat(s,r).format(i)}catch(t){this.textContent=new Intl.DateTimeFormat(s).format(i),console.log(t)}}}}function l(t){return Object(i.b)("intl-datetime",t)}customElements.define("intl-datetime",u)},function(t,e,n){n.r(e),n.d(e,"IntlNumber",(function(){return s})),n.d(e,"intlNumber",(function(){return a}));var r=n(2),i=n(0);const o=["value","lng","options","styleProp","currency","currencyDisplay","currencySign","unit","unitDisplay","notation","compactDisplay","useGrouping","signDisplay","localeMatcher","minimumIntegerDigits","minimumFractionDigits","maximumFractionDigits","minimumSignificantDigits","maximumSignificantDigits","numberingSystem"];class s extends r.a{constructor(){super(o),this._props.value=0}static get observedAttributes(){return Object(i.a)(o)}_properties(t,e){const{_props:n}=this;switch(t){case"options":this._props=Object.assign(n,Object(i.d)(e));break;case"styleProp":"string"==typeof e&&(n.style=e);break;default:n[t]=Object(i.d)(e,e)}}_render(){if(this._initialized){const t=this._props,{value:e,lng:n}=t,r=function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]])}return n}(t,["value","lng"]),i=this._languages(n);try{this.textContent=new Intl.NumberFormat(i,r).format(e)}catch(t){this.textContent=new Intl.NumberFormat(i).format(e),console.log(t)}}}}function a(t){return Object(i.b)("intl-number",t)}customElements.define("intl-number",s)},function(t,e,n){n.r(e),n.d(e,"IntlRelativeTime",(function(){return m})),n.d(e,"intlRelativeTime",(function(){return h}));var r=n(2),i=n(0);const o=["year","month","week","day","hour","minute","second"],s=[12,4,7,24,60,60],a={year:31536e3,quarter:10368e3,month:2592e3,week:604800,day:86400,hour:3600,minute:60},c=(t,e)=>{const n=e.getDay(),{day:r}=t,i=r<0?r+n-7:r-n+7;return r<0?Math.ceil(i/7):Math.floor(i/7)},u=(t,e,n=1)=>Math.trunc((t.getTime()-e.getTime())/1e3/n),l=(t,e)=>{if((s=t)&&s instanceof Date&&!isNaN(s.getTime())){t=t;const e=new Date,i=u(t,e,a.day),s=(n=t,r=e,Math.abs(i)<31?0:Math.trunc(n.getMonth()+12*n.getFullYear()-(r.getMonth()+12*r.getFullYear()))),l={year:Math.trunc(s/12),month:s,week:u(t,e,a.week),day:i,hour:u(t,e,a.hour),minute:u(t,e,a.minute),second:u(t,e)};for(let n=0;n<o.length;n++){const r=o[n];let i=l[r];if(0!==i)return"week"===r&&(i=c(l,e)),{value:i,unit:r,date:t}}return{value:0,unit:"second",date:new Date}}{const n=p({unit:e},!0)*t+Date.now();return{value:Object(i.e)(t),unit:e,date:new Date(n)}}var n,r,s},p=({date:t=new Date,unit:e},n)=>{const r=a[e]||1;let i=(r+u(t,new Date))%r||r;return i<0&&(i=r+i||1),n||(i=Math.trunc(i/6)||1),1e3*i};var d=function(t,e){var n={};for(var r in t)Object.prototype.hasOwnProperty.call(t,r)&&e.indexOf(r)<0&&(n[r]=t[r]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var i=0;for(r=Object.getOwnPropertySymbols(t);i<r.length;i++)e.indexOf(r[i])<0&&Object.prototype.propertyIsEnumerable.call(t,r[i])&&(n[r[i]]=t[r[i]])}return n};const f=["value","lng","options","unit","localeMatcher","styleProp","numeric","update"];class m extends r.a{constructor(){super(f)}static get observedAttributes(){return Object(i.a)(f)}disconnectedCallback(){clearTimeout(this._timerId),super.disconnectedCallback()}_setTimer(){const{date:t,value:e,unit:n}=this._props,r=p({date:t,unit:n});this._timerId=setTimeout((()=>{this._timerId=null;const r=(({value:t,unit:e})=>{if(1===t){const n=o.indexOf(e);t=s[n]||t,e=-1!==n&&o[n+1]||"second"}return{value:t,unit:e}})(l(t,n));r.value!==e?(this._props.value=r.value,this._properties("unit",r.unit),this._render()):this._props.update&&this._setTimer()}),r)}_properties(t,e){const{_props:n}=this;switch(t){case"value":const s=Object(i.c)(e)||Object(i.e)(e)||0;this._props=Object.assign(n,l(s,n.unit));break;case"options":const a=Object(i.d)(e);"object"==typeof a&&(this._props=Object.assign(n,a));break;case"update":(n[t]=Object(i.f)(e))||clearTimeout(this._timerId);break;case"styleProp":"string"==typeof e&&(n.style=e);break;case"unit":n[t]=(r=e,r=String(r).replace(/s$/,""),-1!==o.indexOf(r)?r:"second");break;default:n[t]=Object(i.d)(e,e)}var r}_render(){if(this._initialized){const t=this._props,{value:e=0,lng:n,unit:r="second",update:i}=t,o=d(t,["value","lng","unit","date","update"]);i&&!this._timerId&&this._setTimer();const s=this._languages(n);try{this.textContent=new Intl.RelativeTimeFormat(s,o).format(e,r)}catch(t){this.textContent=new Intl.RelativeTimeFormat(s).format(e,r),console.log(t)}}}}function h(t){const e=d(t,["update"]);return Object(i.b)("intl-relative-time",e)}customElements.define("intl-relative-time",m)},function(t,e,n){n.r(e);var r=n(3);n.d(e,"IntlMessage",(function(){return r.IntlMessage})),n.d(e,"intlMessage",(function(){return r.intlMessage}));var i=n(4);n.d(e,"IntlDatetime",(function(){return i.IntlDatetime})),n.d(e,"intlDatetime",(function(){return i.intlDatetime}));var o=n(6);n.d(e,"IntlRelativeTime",(function(){return o.IntlRelativeTime})),n.d(e,"intlRelativeTime",(function(){return o.intlRelativeTime}));var s=n(5);n.d(e,"IntlNumber",(function(){return s.IntlNumber})),n.d(e,"intlNumber",(function(){return s.intlNumber}))}]);