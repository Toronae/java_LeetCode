import{r as e,h as s}from"./p-ee0b9025.js";import{S as t}from"./p-c74b54ba.js";let a=class{constructor(s){e(this,s)}async componentWillLoad(){var e;this.isChecked="true"==(this.propertyModel.expressions[t.Literal]||(null===(e=this.propertyDescriptor.defaultValue)||void 0===e?void 0:e.toString())||"").toLowerCase()}onCheckChanged(e){this.isChecked=e.target.checked,this.propertyModel.expressions[this.propertyDescriptor.defaultSyntax||t.Literal]=this.isChecked.toString()}onDefaultSyntaxValueChanged(e){this.isChecked="true"==(e.detail||"").toLowerCase()}render(){const e=this.propertyDescriptor,t=e.name,a=t,l=e.label||t;return s("elsa-property-editor",{activityModel:this.activityModel,propertyDescriptor:e,propertyModel:this.propertyModel,onDefaultSyntaxValueChanged:e=>this.onDefaultSyntaxValueChanged(e),"single-line":!0,showLabel:!1},s("div",{class:"elsa-max-w-lg"},s("div",{class:"elsa-relative elsa-flex elsa-items-start"},s("div",{class:"elsa-flex elsa-items-center elsa-h-5"},s("input",{id:a,name:t,type:"checkbox",checked:this.isChecked,value:"true",onChange:e=>this.onCheckChanged(e),class:"focus:elsa-ring-blue-500 elsa-h-4 elsa-w-4 elsa-text-blue-600 elsa-border-gray-300 elsa-rounded"})),s("div",{class:"elsa-ml-3 elsa-text-sm"},s("label",{htmlFor:a,class:"elsa-font-medium elsa-text-gray-700"},l)))))}};export{a as elsa_checkbox_property};