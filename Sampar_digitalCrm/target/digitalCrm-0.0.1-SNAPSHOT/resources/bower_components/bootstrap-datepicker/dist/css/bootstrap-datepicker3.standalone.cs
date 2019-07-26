/*!
 * Datepicker for Bootstrap v1.7.1 (https://github.com/uxsolutions/bootstrap-datepicker)
 *
 * Licensed under the Apache License v2.0 (http://www.apache.org/licenses/LICENSE-2.0)
 */

.datepicker {
  border-radius: 4px;
  direction: ltr;
}
.datepicker-inline {
  width: 220px;
}
.datepicker-rtl {
  direction: rtl;
}
.datepicker-rtl.dropdown-menu {
  left: auto;
}
.datepicker-rtl table tr td span {
  float: right;
}
.datepicker-dropdown {
  top: 0;
  left: 0;
  padding: 4px;
}
.datepicker-dropdown:before {
  content: '';
  display: inline-block;
  border-left: 7px solid transparent;
  border-right: 7px solid transparent;
  border-bottom: 7px solid rgba(0, 0, 0, 0.15);
  border-top: 0;
  border-bottom-color: rgba(0, 0, 0, 0.2);
  position: absolute;
}
.datepicker-dropdown:after {
  content: '';
  display: inline-block;
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  border-bottom: 6px solid #fff;
  border-top: 0;
  position: absolute;
}
.datepicker-dropdown.datepicker-orient-left:before {
  left: 6px;
}
.datepicker-dropdown.datepicker-orient-left:after {
  left: 7px;
}
.datepicker-dropdown.datepicker-orient-right:before {
  right: 6px;
}
.datepicker-dropdown.datepicker-orient-right:after {
  right: 7px;
}
.datepicker-dropdown.datepicker-orient-bottom:before {
  top: -7px;
}
.datepicker-dropdown.datepicker-orient-bottom:after {
  top: -6px;
}
.datepicker-dropdown.datepicker-orient-top:before {
  bottom: -7px;
  border-bottom: 0;
  border-top: 7px solid rgba(0, 0, 0, 0.15);
}
.datepicker-dropdown.datepicker-orient-top:after {
  bottom: -6px;
  border-bottom: 0;
  border-top: 6px solid #fff;
}
.datepicker table {
  margin: 0;
  -webkit-touch-callout: none;
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.datepicker table tr td,
.datepicker table tr th {
  text-align: center;
  width: 30px;
  height: 30px;
  border-radius: 4px;
  border: none;
}
.table-striped .datepicker table tr td,
.table-striped .datepicker table tr th {
  background-color: transparent;
}
.datepicker table tr td.old,
.datepicker table tr td.new {
  color: #777777;
}
.datepicker table tr td.day:hover,
.datepicker table tr td.focused {
  background: #eeeeee;
  cursor: pointer;
}
.datepicker table tr td.disabled,
.datepicker table tr td.disabled:hover {
  background: none;
  color: #777777;
  cursor: default;
}
.datepicker table tr td.highlighted {
  color: #000;
  background-color: #d9edf7;
  border-color: #85c5e5;
  border-radius: 0;
}
.datepicker table tr td.highlighted:focus,
.datepicker table tr td.highlighted.focus {
  color: #000;
  background-color: #afd9ee;
  border-color: #298fc2;
}
.datepicker table tr td.highlighted:hover {
  color: #000;
  background-color: #afd9ee;
  border-color: #52addb;
}
.datepicker table tr td.highlighted:active,
.datepicker table tr td.highlighted.active {
  color: #000;
  background-color: #afd9ee;
  border-color: #52addb;
}
.datepicker table tr td.highlighted:active:hover,
.datepicker table tr td.highlighted.active:hover,
.datepicker table tr td.highlighted:active:focus,
.datepicker table tr td.highlighted.active:focus,
.datepicker table tr td.highlighted:active.focus,
.datepicker table tr td.highlighted.active.focus {
  color: #000;
  background-color: #91cbe8;
  border-color: #298fc2;
}
.datepicker table tr td.highlighted.disabled:hover,
.datepicker table tr td.highlighted[disabled]:hover,
fieldset[disabled] .datepicker table tr td.highlighted:hover,
.datepicker table tr td.highlighted.disabled:focus,
.datepicker table tr td.highlighted[disabled]:focus,
fieldset[disabled] .datepicker table tr td.highlighted:focus,
.datepicker table tr td.highlighted.disabled.focus,
.datepicker table tr td.highlighted[disabled].focus,
fieldset[disabled] .datepicker table tr td.highlighted.focus {
  background-color: #d9edf7;
  border-color: #85c5e5;
}
.datepicker table tr td.highlighted.focused {
  background: #afd9ee;
}
.datepicker table tr td.highlighted.disabled,
.datepicker table tr td.highlighted.disabled:active {
  background: #d9edf7;
  color: #777777;
}
.datepicker table tr td.today {
  color: #000;
  background-color: #ffdb99;
  border-color: #ffb733;
}
.datepicker table tr td.today:focus,
.datepicker table tr td.today.focus {
  color: #000;
  background-color: #ffc966;
  border-color: #b37400;
}
.datepicker table tr td.today:hover {
  color: #000;
  background-color: #ffc966;
  border-color: #f59e00;
}
.datepicker table tr td.today:active,
.datepicker table tr td.today.active {
  color: #000;
  background-color: #ffc966;
  border-color: #f59e00;
}
.datepicker table tr td.today:active:hover,
.datepicker table tr td.today.active:hover,
.datepicker table tr td.today:active:focus,
.datepicker table tr td.today.active:focus,
.datepicker table tr td.today:active.focus,
.datepicker table tr td.today.active.focus {
  color: #000;
  background-color: #ffbc42;
  border-color: #b37400;
}
.datepicker table tr td.today.disabled:hover,
.datepicker table tr td.today[disabled]:hover,
fieldset[disabled] .datepicker table tr td.today:hover,
.datepicker table tr td.today.disabled:focus,
.datepicker table tr td.today[disabled]:focus,
fieldset[disabled] .datepicker table tr td.today:focus,
.datepicker table tr td.today.disabled.focus,
.datepicker table tr td.today[disabled].focus,
fieldset[disabled] .datepicker table tr td.today.focus {
  background-color: #ffdb99;
  border-color: #ffb733;
}
.datepicker table tr td.today.focused {
  background: #ffc966;
}
.datepicker table tr td.today.disabled,
.datepicker table tr td.today.disabled:active {
  background: #ffdb99;
  color: #777777;
}
.datepicker table tr td.range {
  color: #000;
  background-color: #eeeeee;
  border-color: #bbbbbb;
  border-radius: 0;
}
.datepicker table tr td.range:focus,
.datepicker table tr td.range.focus {
  color: #000;
  background-color: #d5d5d5;
  border-color: #7c7c7c;
}
.datepicker table tr td.range:hover {
  color: #000;
  background-color: #d5d5d5;
  border-color: #9d9d9d;
}
.datepicker table tr td.range:active,
.datepicker table tr td.range.active {
  color: #000;
  background-color: #d5d5d5;
  border-color: #9d9d9d;
}
.datepicker table tr td.range:active:hover,
.datepicker table tr td.range.active:hover,
.datepicker table tr td.range:active:focus,
.datepicker table tr td.range.active:focus,
.datepicker table tr td.range:active.focus,
.datepicker table tr td.range.active.focus {
  color: #000;
  background-color: #c3c3c3;
  border-color: #7c7c7c;
}
.datepicker table tr td.range.disabled:hover,
.datepicker table tr td.range[disabled]:hover,
fieldset[disabled] .datepicker table tr td.range:hover,
.datepicker table tr td.range.disabled:focus,
.datepicker table tr td.range[disabled]:focus,
fieldset[disabled] .datepicker table tr td.range:focus,
.datepicker table tr td.range.disabled.focus,
.datepicker table tr td.range[disabled].focus,
fieldset[disabled] .datepicker table tr td.range.focus {
  background-color: #eeeeee;
  border-color: #bbbbbb;
}
.datepicker table tr td.range.focused {
  background: #d5d5d5;
}
.datepicker table tr td.range.disabled,
.datepicker table tr td.range.disabled:active {
  background: #eeeeee;
  color: #777777;
}
.datepicker table tr td.range.highlighted {
  color: #000;
  background-color: #e4eef3;
  border-color: #9dc1d3;
}
.datepicker table tr td.range.highlighted:focus,
.datepicker table tr td.range.highlighted.focus {
  color: #000;
  background-color: #c1d7e3;
  border-color: #4b88a6;
}
.datepicker table tr td.range.highlighted:hover {
  color: #000;
  background-color: #c1d7e3;
  border-color: #73a6c0;
}
.datepicker table tr td.range.highlighted:active,
.datepicker table tr td.range.highlighted.active {
  color: #000;
  background-color: #c1d7e3;
  border-color: #73a6c0;
}
.datepicker table tr td.range.highlighted:active:hover,
.datepicker table tr td.range.highlighted.active:hover,
.datepicker table tr td.range.highlighted:active:focus,
.datepicker table tr td.range.highlighted.active:focus,
.datepicker table tr td.range.highlighted:active.focus,
.datepicker table tr td.range.highlighted.active.focus {
  color: #000;
  background-color: #a8c8d8;
  border-color: #4b88a6;
}
.datepicker table tr td.range.highlighted.disabled:hover,
.datepicker table tr td.range.highlighted[disabled]:hover,
fieldset[disabled] .datepicker table tr td.range.highlighted:hover,
.datepicker table tr td.range.highlighted.disabled:focus,
.datepicker table tr td.range.highlighted[disabled]:focus,
fieldset[disabled] .datepicker table tr td.range.highlighted:focus,
.datepicker table tr td.range.highlighted.disabled.focus,
.datepicker table tr td.range.highlighted[disabled].focus,
fieldset[disabled] .datepicker table tr td.range.highlighted.focus {
  background-color: #e4eef3;
  border-color: #9dc1d3;
}
.datepicker table tr td.range.highlighted.focused {
  background: #c1d7e3;
}
.datepicker table tr td.range.highlighted.disabled,
.datepicker table tr td.range.highlighted.disabled:active {
  background: #e4eef3;
  color: #777777;
}
.datepicker table tr td.range.today {
  color: #000;
  background-color: #f7ca77;
  border-color: #f1a417;
}
.datepicker table tr td.range.today:focus,
.datepicker table tr td.range.today.focus {
  color: #000;
  background-color: #f4b747;
  border-color: #815608;
}
.datepicker table tr td.range.today:hover {
  color: #000;
  background-color: #f4b747;
  border-color: #bf800c;
}
.datepicker table tr td.range.today:active,
.datepicker table tr td.range.today.active {
  color: #000;
  background-color: #f4b747;
  border-color: #bf800c;
}
.datepicker table tr td.range.today:active:hover,
.datepicker table tr td.range.today.active:hover,
.datepicker table tr td.range.today:active:focus,
.datepicker table tr td.range.today.active:focus,
.datepicker table tr td.range.today:active.focus,
.datepicker table tr td.range.today.active.focus {
  color: #000;
  background-color: #f2aa25;
  border-color: #815608;
}
.datepicker table tr td.range.today.disabled:hover,
.datepicker table tr td.range.today[disabled]:hover,
fieldset[disabled] .datepicker table tr td.range.today:hover,
.datepicker table tr td.range.today.disabled:focus,
.datepicker table tr td.range.today[disabled]:focus,
fieldset[disabled] .datepicker table tr td.range.today:focus,
.datepicker table tr td.range.today.disabled.focus,
.datepicker table tr td.range.today[disabled].focus,
fieldset[disabled] .datepicker table tr td.range.today.focus {
  background-color: #f7ca77;
  border-color: #f1a417;
}
.datepicker table tr td.range.today.disabled,
.datepicker table tr td.range.today.disabled:active {
  background: #f7ca77;
  color: #777777;
}
.datepicker table tr td.selected,
.datepicker table tr td.selected.highlighted {
  color: #fff;
  background-color: #777777;
  border-color: #555555;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.datepicker table tr td.selected:focus,
.datepicker table tr td.selected.highlighted:focus,
.datepicker table tr td.selected.focus,
.datepicker table tr td.selected.highlighted.focus {
  color: #fff;
  background-color: #5e5e5e;
  border-color: #161616;
}
.datepicker table tr td.selected:hover,
.datepicker table tr td.selected.highlighted:hover {
  color: #fff;
  background-color: #5e5e5e;
  border-color: #373737;
}
.datepicker table tr td.selected:active,
.datepicker table tr td.selected.highlighted:active,
.datepicker table tr td.selected.active,
.datepicker table tr td.selected.highlighted.active {
  color: #fff;
  background-color: #5e5e5e;
  border-color: #373737;
}
.datepicker table tr td.selected:active:hover,
.datepicker table tr td.selected.highlighted:active:hover,
.datepicker table tr td.selected.active:hover,
.datepicker table tr td.selected.highlighted.active:hover,
.datepicker table tr td.selected:active:focus,
.datepicker table tr td.selected.highlighted:active:focus,
.datepicker table tr td.selected.active:focus,
.datepicker table tr td.selected.highlighted.active:focus,
.datepicker table tr td.selected:active.focus,
.datepicker table tr td.selected.highlighted:active.focus,
.datepicker table tr td.selected.active.focus,
.datepicker table tr td.selected.highlighted.active.focus {
  color: #fff;
  background-color: #4c4c4c;
  border-color: #161616;
}
.datepicker table tr td.selected.disabled:hover,
.datepicker table tr td.selected.highlighted.disabled:hover,
.datepicker table tr td.selected[disabled]:hover,
.datepicker table tr td.selected.highlighted[disabled]:hover,
fieldset[disabled] .datepicker table tr td.selected:hover,
fieldset[disabled] .datepicker table tr td.selected.highlighted:hover,
.datepicker table tr td.selected.disabled:focus,
.datepicker table tr td.selected.highlighted.disabled:focus,
.datepicker table tr td.selected[disabled]:focus,
.datepicker table tr td.selected.highlighted[disabled]:focus,
fieldset[disabled] .datepicker table tr td.selected:focus,
fieldset[disabled] .datepicker table tr td.selected.highlighted:focus,
.datepicker table tr td.selected.disabled.focus,
.datepicker table tr td.selected.highlighted.disabled.focus,
.datepicker table tr td.selected[disabled].focus,
.datepicker table tr td.selected.highlighted[disabled].focus,
fieldset[disabled] .datepicker table tr td.selected.focus,
fieldset[disabled] .datepicker table tr td.selected.highlighted.focus {
  background-color: #777777;
  border-color: #555555;
}
.datepicker table tr td.active,
.datepicker table tr td.active.highlighted {
  color: #fff;
  background-color: #337ab7;
  border-color: #2e6da4;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.datepicker table tr td.active:focus,
.datepicker table tr td.active.highlighted:focus,
.datepicker table tr td.active.focus,
.datepicker table tr td.active.highlighted.focus {
  color: #fff;
  background-color: #286090;
  border-color: #122b40;
}
.datepicker table tr td.active:hover,
.datepicker table tr td.active.highlighted:hover {
  color: #fff;
  background-color: #286090;
  border-color: #204d74;
}
.datepicker table tr td.active:active,
.datepicker table tr td.active.highlighted:active,
.datepicker table tr td.active.active,
.datepicker table tr td.active.highlighted.active {
  color: #fff;
  background-color: #286090;
  border-color: #204d74;
}
.datepicker table tr td.active:active:hover,
.datepicker table tr td.active.highlighted:active:hover,
.datepicker table tr td.active.active:hover,
.datepicker table tr td.active.highlighted.active:hover,
.datepicker table tr td.active:active:focus,
.datepicker table tr td.active.highlighted:active:focus,
.datepicker table tr td.active.active:focus,
.datepicker table tr td.active.highlighted.active:focus,
.datepicker table tr td.active:active.focus,
.datepicker table tr td.active.highlighted:active.focus,
.datepicker table tr td.active.active.focus,
.datepicker table tr td.active.highlighted.active.focus {
  color: #fff;
  background-color: #204d74;
  border-color: #122b40;
}
.datepicker table tr td.active.disabled:hover,
.datepicker table tr td.active.highlighted.disabled:hover,
.datepicker table tr td.active[disabled]:hover,
.datepicker table tr td.active.highlighted[disabled]:hover,
fieldset[disabled] .datepicker table tr td.active:hover,
fieldset[disabled] .datepicker table tr td.active.highlighted:hover,
.datepicker table tr td.active.disabled:focus,
.datepicker table tr td.active.highlighted.disabled:focus,
.datepicker table tr td.active[disabled]:focus,
.datepicker table tr td.active.highlighted[disabled]:focus,
fieldset[disabled] .datepicker table tr td.active:focus,
fieldset[disabled] .datepicker table tr td.active.highlighted:focus,
.datepicker table tr td.active.disabled.focus,
.datepicker table tr td.active.highlighted.disabled.focus,
.datepicker table tr td.active[disabled].focus,
.datepicker table tr td.active.highlighted[disabled].focus,
fieldset[disabled] .datepicker table tr td.active.focus,
fieldset[disabled] .datepicker table tr td.active.highlighted.focus {
  background-color: #337ab7;
  border-color: #2e6da4;
}
.datepicker table tr td span {
  display: block;
  width: 23%;
  height: 54px;
  line-height: 54px;
  float: left;
  margin: 1%;
  cursor: pointer;
  border-radius: 4px;
}
.datepicker table tr td span:hover,
.datepicker table tr td span.focused {
  background: #eeeeee;
}
.datepicker table tr td span.disabled,
.datepicker table tr td span.disabled:hover {
  background: none;
  color: #777777;
  cursor: default;
}
.datepicker table tr td span.active,
.datepicker table tr td span.active:hover,
.datepicker table tr td span.active.disabled,
.datepicker table tr td span.active.disabled:hover {
  color: #fff;
  background-color: #337ab7;
  border-color: #2e6da4;
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
.datepicker table tr td span.active:focus,
.datepicker table tr td span.active:hover:focus,
.datepicker table tr td span.active.disabled:focus,
.datepicker table tr td span.active.disabled:hover:focus,
.datepicker table tr td span.active.focus,
.datepicker table tr td span.active:hover.focus,
.datepicker table tr td span.active.disabled.focus,
.datepicker table tr td span.active.disabled:hover.focus {
  color: #fff;
  background-color: #286090;
  border-color: #122b40;
}
.datepicker table tr td span.active:hover,
.datepicker table tr td span.active:hover:hover,
.datepicker table tr td span.active.disabled:hover,
.datepicker table tr td span.active.disabled:hover:hover {
  color: #fff;
  background-color: #286090;
  border-color: #204d74;
}
.datepicker table tr td span.active:active,
.datepicker table tr td span.active:hover:active,
.datepicker table tr td span.active.disabled:active,
.datepicker table tr td span.active.disabled:hover:active,
.datepicker table tr td span.active.active,
.datepicker table tr td span.active:hover.active,
.datepicker table tr td span.active.disabled.active,
.datepicker table tr td span.active.disabled:hover.active {
  color: #fff;
  background-color: #286090;
  border-color: #204d74;
}
.datepicker table tr td span.active:active:hover,
.datepicker table tr td span.active:hover:active:hover,
.datepicker table tr td span.active.disabled:active:hover,
.datepicker table tr td span.active.disabled:hover:active:hover,
.datepicker table tr td span.active.active:hover,
.datepicker table tr td span.active:hover.active:hover,
.datepicker table tr td span.active.disabled.active:hover,
.datepicker table tr td span.active.disabled:hover.active:hover,
.datepicker table tr td span.active:active:focus,
.datepicker table tr td span.active:hover:active:focus,
.datepicker table tr td span.active.disabled:active:focus,
.datepicker table tr td span.active.disabled:hover:active:focus,
.datepicker table tr td span.active.active:focus,
.datepicker table tr td span.active:hover.active:focus,
.datepicker table tr td span.active.disabled.active:focus,
.datepicker table tr td span.active.disabled:hover.active:focus,
.datepicker table tr td span.active:active.focus,
.datepicker table tr td span.active:hover:active.focus,
.datepicker table tr td span.active.disabled:active.focus,
.datepicker table tr td span.active.disabled:hover:active.focus,
.datepicker table tr td span.active.active.focus,
.datepicker table tr td span.active:hover.active.focus,
.datepicker table tr td span.active.disabled.active.focus,
.datepicker table tr td span.active.disabled:hover.active.focus {
  color: #fff;
  background-color: #204d74;
  border-color: #122b40;
}
.datepicker table tr td span.active.disabled:hover,
.datepicker table tr td span.active:hover.disabled:hover,
.datepicker table tr td span.active.disabled.disabled:hover,
.datepicker table tr td span.active.disabled:hover.disabled:hover,
.datepicker table tr td span.active[disabled]:hover,
.datepicker table tr td span.active:hover[disabled]:hover,
.datepicker table tr td span.active.disabled[disabled]:hover,
.datepicker table tr td span.active.disabled:hover[disabled]:hover,
fieldset[disabled] .datepicker table tr td span.active:hover,
fieldset[disabled] .datepicker table tr td span.active:hover:hover,
fieldset[disabled] .datepicker table tr td span.active.disabled:hover,
fieldset[disabled] .datepicker table tr td span.active.disabled:hover:hover,
.datepicker table tr td span.active.disabled:focus,
.datepicker table tr td span.active:hover.disabled:focus,
.datepicker table tr td span.active.disabled.disabled:focus,
.datepicker table tr td span.active.disabled:hover.disabled:focus,
.datepicker table tr td span.active[disabled]:focus,
.datepicker table tr td span.active:hover[disabled]:focus,
.datepicker table tr td span.active.disabled[disabled]:focus,
.datepicker table tr td span.active.disabled:hover[disabled]:focus,
fieldset[disabled] .datepicker table tr td span.active:focus,
fieldset[disabled] .datepicker table tr td span.active:hover:focus,
fieldset[disabled] .datepicker table tr td span.active.disabled:focus,
fieldset[disabled] .datepicker table tr td span.active.disabled:hover:focus,
.datepicker table tr td span.active.disabled.focus,
.datepicker table tr td span.active:hover.disabled.focus,
.datepicker table tr td span.active.disabled.disabled.focus,
.datepicker table tr td span.active.disabled:hover.disabled.focus,
.datepicker table tr td span.active[disabled].focus,
.datepicker table tr td span.active:hover[disabled].focus,
.datepicker table tr td span.active.disabled[disabled].focus,
.datepicker table tr td span.active.disabled:hover[disabled].focus,
fieldset[disabled] .datepicker table tr td span.active.focus,
fieldset[disabled] .datepicker table tr td span.active:hover.focus,
fieldset[disabled] .datepicker table tr td span.active.disabled.focus,
fieldset[disabled] .datepicker table tr td span.active.disabled:hover.focus {
  background-color: #337ab7;
  border-color: #2e6da4;
}
.datepicker table tr td span.old,
.datepicker table tr td span.new {
  color: #777777;
}
.datepicker .datepicker-switch {
  width: 145px;
}
.datepicker .datepicker-switch,
.datepicker .prev,
.datepicker .next,
.datepicker tfoot tr th {
  cursor: pointer;
}
.datepicker .datepicker-switch:hover,
.datepicker .prev:hover,
.datepicker .next:hover,
.datepicker tfoot tr th:hover {
  background: #eeeeee;
}
.datepicker .prev.disabled,
.datepicker .next.disabled {
  visibility: hidden;
}
.datepicker .cw {
  font-size: 10px;
  width: 12px;
  padding: 0 2px 0 5px;
  vertical-align: middle;
}
.input-group.date .input-group-addon {
  cursor: pointer;
}
.input-daterange {
  width: 100%;
}
.input-daterange input {
  text-align: center;
}
.input-daterange input:first-child {
  border-radius: 3px 0 0 3px;
}
.input-daterange input:last-child {
  border-radius: 0 3px 3px 0;
}
.input-daterange .input-group-addon {
  width: auto;
  min-width: 16px;
  padding: 4px 5px;
  line-height: 1.42857143;
  text-shadow: 0 1px 0 #fff;
  border-width: 1px 0;
  margin-left: -5px;
  margin-right: -5px;
}
.datepicker.dropdown-menu {
  position: absolute;
  top: 100%;
  left: 0;
  z-index: 1000;
  display: none;
  float: left;
  min-width: 160px;
  list-style: none;
  background-color: #fff;
  border: 1px solid #ccc;
  border: 1px solid rgba(0, 0, 0, 0.15);
  border-radius: 4px;
  -webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
  -moz-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);
  -webkit-background-clip: padding-box;
  -moz-background-clip: padding;
  background-clip: padding-box;
  color: #333333;
  font-size: 13px;
  line-height: 1.42857143;
}
.datepicker.dropdown-menu th,
.datepicker.datepicker-inline th,
.datepicker.dropdown-menu td,
.datepicker.datepicker-inline td {
  padding: 0px 5px;
}
/*# sourceMappingURL=bootstrap-datepicker3.standalone.css.map */