import{r as s,h as e}from"./p-ee0b9025.js";import{S as t}from"./p-c74b54ba.js";import{g as a}from"./p-8f8bc806.js";import{T as i}from"./p-37df3757.js";import"./p-ccd51ea4.js";import"./p-e0c1fede.js";import"./p-f1ec68ec.js";import"./p-a3b5bd35.js";import"./p-80de33dc.js";import"./p-93cac3a6.js";import"./p-d88cb309.js";import"./p-971980b1.js";import"./p-82db2ff5.js";import"./p-949334ec.js";import"./p-83f217d4.js";let r=class{constructor(e){s(this,e),this.selectList={items:[],isFlagsEnum:!1}}async componentWillLoad(){this.currentValue=this.propertyModel.expressions[this.propertyDescriptor.defaultSyntax||t.Literal]||null}onCheckChanged(e){const s=e.target;s.checked&&(this.currentValue=s.value),this.propertyModel.expressions[this.propertyDescriptor.defaultSyntax||t.Literal]=this.currentValue}onDefaultSyntaxValueChanged(e){this.currentValue=e.detail}async componentWillRender(){this.selectList=await a(this.serverUrl,this.propertyDescriptor)}render(){const t=this.propertyDescriptor,s=t.name,r=this.currentValue;return e("elsa-property-editor",{activityModel:this.activityModel,propertyDescriptor:t,propertyModel:this.propertyModel,onDefaultSyntaxValueChanged:e=>this.onDefaultSyntaxValueChanged(e),"single-line":!0},e("div",{class:"elsa-max-w-lg elsa-space-y-3 elsa-my-4"},this.selectList.items.map(((t,a)=>{const i=`${s}_${a}`,l="string"==typeof t,o=l?t:t.value,p=l?t:t.text;return e("div",{class:"elsa-relative elsa-flex elsa-items-start"},e("div",{class:"elsa-flex elsa-items-center elsa-h-5"},e("input",{id:i,type:"radio",radioGroup:s,checked:r==o,value:o,onChange:e=>this.onCheckChanged(e),class:"elsa-focus:ring-blue-500 elsa-h-4 elsa-w-4 elsa-text-blue-600 elsa-border-gray-300"})),e("div",{class:"elsa-ml-3 elsa-mt-1 elsa-text-sm"},e("label",{htmlFor:i,class:"elsa-font-medium elsa-text-gray-700"},p)))}))))}};i.injectProps(r,["serverUrl"]);export{r as elsa_radio_list_property};