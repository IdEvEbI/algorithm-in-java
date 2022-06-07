<p>给你一个整数数组&nbsp;<code>arr</code>，请你检查是否存在两个整数&nbsp;<code>N</code> 和 <code>M</code>，满足&nbsp;<code>N</code>&nbsp;是&nbsp;<code>M</code>&nbsp;的两倍（即，<code>N = 2 * M</code>）。</p>

<p>更正式地，检查是否存在两个下标&nbsp;<code>i</code> 和 <code>j</code> 满足：</p>

<ul>
	<li><code>i != j</code></li>
	<li><code>0 &lt;= i, j &lt; arr.length</code></li>
	<li><code>arr[i] == 2 * arr[j]</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>arr = [10,2,5,3]
<strong>输出：</strong>true
<strong>解释：</strong>N<code> = 10</code> 是 M<code> = 5 的两倍</code>，即 <code>10 = 2 * 5 。</code>
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>arr = [7,1,14,11]
<strong>输出：</strong>true
<strong>解释：</strong>N<code> = 14</code> 是 M<code> = 7 的两倍</code>，即 <code>14 = 2 * 7 </code>。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>arr = [3,1,7,11]
<strong>输出：</strong>false
<strong>解释：</strong>在该情况下不存在 N 和 M 满足 N = 2 * M 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 500</code></li>
	<li><code>-10^3 &lt;= arr[i] &lt;= 10^3</code></li>
</ul>
<div><li>👍 58</li><li>👎 0</li></div>