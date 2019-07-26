/*
Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.md or https://ckeditor.com/legal/ckeditor-oss-license
*/

.cke_balloon
{
	position: absolute;
	z-index: 10000;

	background: #fff;
	border: 1px solid #b2b2b2;
	border-bottom-color: #999;

	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
	border-radius: 3px;

	-moz-box-shadow: 0 0 3px rgba(0, 0, 0, .15);
	-webkit-box-shadow: 0 0 3px rgba(0, 0, 0, .15);
	box-shadow: 0 0 3px rgba(0, 0, 0, .15);

	outline: none;
}

.cke_balloon_title
{
	font-weight: bold;
	font-size: 14px;
	cursor: default;

	color: #474747;
	text-shadow: 0 1px 0 rgba(255,255,255,.75);

	padding: 3px 3px 8px;
	border-bottom: 1px solid #eee;

	-moz-border-radius: 2px 2px 0 0;
	-webkit-border-radius: 2px 2px 0 0;
	border-radius: 2px 2px 0 0;

	-moz-box-shadow: 0 1px 0 #fff inset;
	-webkit-box-shadow: 0 1px 0 #fff inset;
	box-shadow: 0 1px 0 #fff inset;
}

/* The close button at the top of the panel. */
a.cke_balloon_close_button
{
	background-image: url(../../../../skins/kama/images/sprites.png);
	background-repeat: no-repeat;
	background-position: 0 -1022px;
	position: absolute;
	cursor: pointer;
	text-align: center;
	height: 20px;
	width: 20px;
	top: 5px;
}

a.cke_balloon_close_button:hover {
	background-position: 0 -1045px;
}

.cke_balloon_content
{
	overflow: hidden;
	min-height: 68px;
}

.cke_balloon_close_button:hover
{
	opacity: 1;
	filter: alpha(opacity = 100);
}

.cke_balloon_close_button span
{
	display: none;
}

.cke_ltr .cke_balloon_close_button
{
	right: 5px;
}

.cke_rtl .cke_balloon_close_button
{
	left: 6px;
}

.cke_balloon_triangle
{
	position: absolute;
	border-style: solid;
	display: block;
	width: 0;
	height: 0;
}

.cke_balloon_triangle_inner
{
	z-index: 0;
}

.cke_balloon_triangle_outer
{
	z-index: 0;
}

/* side: [ bottom, top ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_bottom,
	.cke_balloon_triangle_outer.cke_balloon_triangle_top
	{
		border-color: #6B6B6B transparent;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_bottom,
	.cke_balloon_triangle_inner.cke_balloon_triangle_top
	{
		left: -20px;
	}

/* side: [ bottom ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_bottom
	{
		border-width: 20px 20px 0;
		bottom: -20px;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_bottom
	{
		border-color: #fff transparent;
		border-width: 20px 20px 0;
		top: -21px;
	}

/* side: [ top ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_top
	{
		border-width: 0 20px 20px;
		top: -20px;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_top
	{
		border-color: #fff transparent;
		border-width: 0 20px 20px;
		top: 1px;
	}

/* side: [ left, right ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_left,
	.cke_balloon_triangle_outer.cke_balloon_triangle_right
	{
		border-color: transparent #6B6B6B;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_left,
	.cke_balloon_triangle_inner.cke_balloon_triangle_right
	{
		border-color: transparent #fff;
		top: -20px;
	}

/* side: [ left ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_left
	{
		border-width: 20px 20px 20px 0;
		left: -20px;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_left
	{
		border-color: transparent #fff;
		border-width: 20px 20px 20px 0;
		left: 1px;
	}

/* side: [ right ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_right
	{
		border-width: 20px 0 20px 20px;
		right: -20px;
	}

	.cke_balloon_triangle_inner.cke_balloon_triangle_right
	{
		border-width: 20px 0 20px 20px;
		right: 1px;
	}


/* align: [ hcenter ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_align_hcenter
	{
		left: 50%;
		margin-left: -20px;
	}

/* align: [ left ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_align_left
	{
		left: 20px;
		margin-left: 0;
	}

/* align: [ right ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_align_right
	{
		right: 20px;
		margin-left: 0;
	}

/* align: [ vcenter ] */
	.cke_balloon_triangle_outer.cke_balloon_triangle_align_vcenter
	{
		top: 50%;
		margin-top: -20px;
	}
