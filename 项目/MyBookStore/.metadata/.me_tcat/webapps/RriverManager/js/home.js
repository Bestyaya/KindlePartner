var wrapper = {};

//设置
wrapper.settings = {
    homeTabTitle: '我的桌面',
    homeTabUrl: 'http://www.baidu.com',
    maxTabCount: 10
};

//初始化
wrapper.init = function () {
    com.ajax({ type: 'POST', url: rootPath+'/sys/menu!getUserMenu.do', success: wrapper.initMenu });
    
    $('.loginOut').click(wrapper.logout);
    $('.changepwd').click(wrapper.changePassword);
    $('#notity').jnotifyInizialize({ oneAtTime: true, appendType: 'append' }).css({ 'position': 'absolute', '*top': '2px', 'left': '50%', 'margin': '20px 0px 0px -120px', '*margin': '0px 0px 0px -120px', 'width': '240px', 'z-index': '9999' });
    $('#closeMenu').menu({ onClick: wrapper.rightMenuClick });

    $('#tabs').tabs({
        tools: [{ iconCls: 'icon-arrow_refresh', handler: wrapper.tabRefresh },
                { iconCls: 'icon-screen_full', handler: wrapper.setFullScreen },
                { iconCls: 'panel-tool-close', handler: wrapper.tabClose }],
        onContextMenu: wrapper.tabContextMenu,
        onClose: wrapper.setLocationHash,
        onSelect: wrapper.setLocationHash
    });
};

wrapper.initMenu = function (d) {
    if (!d || !d.length) {
        $.messager.alert("系统提示", "<font color=red><b>您没有任何权限！请联系管理员。</b></font>", "warning", function () { location.href = '/login'; });
        return;
    }

    $('body').data('menulist', d);
    var visibleMenu = $.grep(d, function (row) {return row.isVisible;});
    $.each(visibleMenu, function () {
        var urlStart = this.menuUrl.substring(0,7);
        if(urlStart!="#" && urlStart!="http://"){
            this.menuUrl = rootPath+this.menuUrl;
        }
    })
    var menus = utils.toTreeData(visibleMenu, 'id', 'parentId', 'children');

    switch (wrapper.settings.navigation) {
        case "tree":
            wrapper.menuTree(menus);
            break;
        case "accordion":
            wrapper.menuAccordion(menus);
            break;
        default:
            wrapper.menuAccordion(menus);
            break;

    }
    wrapper.initLocationHash(d);
    $("#home").html(wrapper.createFrame(wrapper.settings.homeTabUrl));
};

//菜单生成
wrapper.menuAccordion = function (menus) {
    var $obj = $('#wnav');
    $obj.accordion({ animate: false, fit: true, border: false });
    $.each(menus, function () {
        var html = '<ul>';
        var temple = '<li><div><a ref="{0}" href="javascript:void(0)" rel="{1}"><span class="icon {2}">&nbsp;</span><span class="nav">{3}</span></a></div></li>';
        $.each(this.children || [], function () {
            html += utils.formatString(temple, this.menuCode, this.menuUrl, this.iconClass, this.menuName);
        });
        html += '</ul>';

        $obj.accordion('add', {
            title: this.menuName,
            content: html,
            iconCls: 'icon ' + this.iconClass,
            border: false
        });
    });

    var panels = $obj.accordion('panels');
    $obj.accordion('select', panels[0].panel('options').title);

    $obj.find('li').click(function () {
        $obj.find('li div').removeClass("selected");
        $(this).children('div').addClass("selected");

        var link = $(this).find('a');
        var title = link.children('.nav').text();
        var url = link.attr("rel");
        var code = link.attr("ref");
        var icon = link.children('.icon').attr('class');

        wrapper.addTab(title, url, icon);
    }).hover(function () {
        $(this).children('div').addClass("hover");
    }, function () {
        $(this).children('div').removeClass("hover");
    });
};

wrapper.initLocationHash = function (data) {
    var subUrl = location.hash.replace('#!', '');
    $.each(data, function () {
        var s = this.url;
        if (this.url && this.url != '#' && (subUrl == s || subUrl.indexOf(s + "/") > -1))
            wrapper.addTab(this.menuName, subUrl, this.iconClass);
    });
};

wrapper.setLocationHash = function(){
    try {
        var $obj = $('#tabs');
        var src = '', tabs = $obj.data().tabs.tabs;
        var tab = $obj.tabs('getSelected');

        var fnSrc = function (tab) {
            var iframe = tab.find('iframe');
            return iframe.length ? iframe[0].src.replace(location.host, '').replace('http://', '') : '';
        };

        if (tab) {
            src = fnSrc(tab);
            if (src) window.location.hash = '!' + src;   //如果src没有，就不设置，case在f5刷新时出现
            if (src == homeUrl) window.location.hash = '';
        }
        else {
            src = fnSrc(tabs[tabs.length - 1]); //关闭tabs时，当前tab为空
            window.location.hash = '!' + src;
        }
    }
    catch (e) { }
}

wrapper.addTab = function (subtitle, url, icon) {
    if (!url|| url == '#') return false;
    var $tab = $('#tabs');
    var tabCount = $tab.tabs('tabs').length;
    var hasTab = $tab.tabs('exists', subtitle);
    if ((tabCount <= wrapper.settings.maxTabCount) || hasTab) 
        wrapper.openTabHandler($tab, hasTab, subtitle, url, icon);
    else
        $.messager.confirm("系统提示", '<b>您当前打开了太多的页面，如果继续打开，会造成程序运行缓慢，无法流畅操作！</b>', function (b) {
            if (b)
                wrapper.openTabHandler($tab, hasTab, subtitle, url, icon);
        });
};

wrapper.openTabHandler = function ($tab,hasTab, subtitle,url,icon) {
    if (!hasTab) {
        $tab.tabs('add', {title: subtitle,content: wrapper.createFrame(url),closable: true,icon: icon});
    } else {
        $tab.tabs('select', subtitle);
        wrapper.tabRefresh(url);   //选择TAB时刷新页面
    }
    wrapper.setLocationHash();
};

wrapper.tabRefresh = function (url) {
    var $tab = $("#tabs");
    var currentTab = $tab.tabs('getSelected');
    var src = $(currentTab.panel('options').content).attr('src');
    if (src == undefined){
        var fnSrc = function (tab) {
            var iframe = tab.find('iframe');
            return iframe.length ? iframe[0].src : '';
        };
        src = fnSrc(currentTab);
    }
    if (typeof url === 'string') src = url;
    $tab.tabs('update', { tab: currentTab, options: { content: wrapper.createFrame(src) } })
};

wrapper.createFrame = function (url) {
    return '<iframe scrolling="auto" frameborder="0" >;
}

//事件
wrapper.tabContextMenu = function (e, title) {
    $('#closeMenu').menu('show', {left: e.pageX,top: e.pageY});
    $('#tabs').tabs('select', title);
    e.preventDefault();
};

wrapper.changePassword = function () {
    com.dialog({
        title: "&nbsp;修改密码",
        iconCls: 'icon-key',
        width: 320,
        height: 195,
        html: "#password-template",
        viewModel: function (w) {
            w.find("#pwd_confirm").click(function () { w.dialog('close'); });
            w.find("#pwd_close").click(function () { w.dialog('close'); });
        }
    });
};

wrapper.logout = function () {
    $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function (r) {
        if (r) location.href = 'javascript:void(0)';
    });
};

wrapper.setFullScreen = function () {
    var that = $(this);
    if (that.find('.icon-screen_full').length) {
        that.find('.icon-screen_full').removeClass('icon-screen_full').addClass('icon-screen_actual');
        $('[region=north],[region=west]').panel('close')
        var panels = $('body').data().layout.panels;
        panels.north.length = 0;
        panels.west.length = 0;
        if (panels.expandWest) {
            panels.expandWest.length = 0;
            $(panels.expandWest[0]).panel('close');
        }
        $('body').layout('resize');
    } else if ($(this).find('.icon-screen_actual').length) {
        that.find('.icon-screen_actual').removeClass('icon-screen_actual').addClass('icon-screen_full');
        $('[region=north],[region=west]').panel('open');
        var panels = $('body').data().layout.panels;
        panels.north.length = 1;
        panels.west.length = 1;
        if ($(panels.west[0]).panel('options').collapsed) {
            panels.expandWest.length = 1;
            $(panels.expandWest[0]).panel('open');
        }
        $('body').layout('resize');
    }
};

wrapper.tabClose = function () {
    if (confirm('确认要关闭所有窗口吗？')) 
        wrapper.rightMenuClick({ id: 'closeall' });
};

wrapper.rightMenuClick = function (item) {
    var $tab = $('#tabs');
    var currentTab = $tab.tabs('getSelected');
    var titles = wrapper.getTabTitles($tab);

    switch (item.id) {
        case "refresh":
            var src = $(currentTab.panel('options').content).attr('src');
            if (src == undefined){
                var fnSrc = function (tab) {
                    var iframe = tab.find('iframe');
                    return iframe.length ? iframe[0].src : '';
                };
                src = fnSrc(currentTab);
            }
            $tab.tabs('update', { tab: currentTab, options: { content: wrapper.createFrame(src) } });
            break;
        case "close":
            var currtab_title = currentTab.panel('options').title;
            $tab.tabs('close', currtab_title);
            break;
        case "closeall":
            $.each(titles, function () {
                if (this != wrapper.settings.homeTabTitle)
                    $tab.tabs('close', this);
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel('options').title;
            $.each(titles, function () {
                if (this != currtab_title && this != wrapper.settings.homeTabTitle)
                    $tab.tabs('close', this);
            });
            break;
        case "closeright":
            var tabIndex = $tab.tabs('getTabIndex', currentTab);
            if (tabIndex == titles.length - 1) {
                alert('亲，后边没有啦 ^@^!!');
                return false;
            }
            $.each(titles, function (i) {
                if (i > tabIndex && this != wrapper.settings.homeTabTitle)
                    $tab.tabs('close', this);
            });

            break;
        case "closeleft":
            var tabIndex = $tab.tabs('getTabIndex', currentTab);
            if (tabIndex == 1) {
                alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
                return false;
            }
            $.each(titles, function (i) {
                if (i < tabIndex && this != wrapper.settings.homeTabTitle)
                    $tab.tabs('close', this);
            });
            break;
        case "exit":
            $('#closeMenu').menu('hide');
            break;
    }

};

wrapper.getTabTitles = function ($tab) {
    var titles = [];
    var tabs = $tab.tabs('tabs');
    $.each(tabs, function () { titles.push($(this).panel('options').title); });
    return titles;
};

wrapper.menuTree = function (menus) {
    var settings = { data: { key: { name: "menuName"} },callback: { onClick:wrapper.treeOnClick }};
    var $obj = $('#wnav').addClass("ztree");
    if (menus.length > 0) menus[0].open = true;
    $.fn.zTree.init($obj, settings, menus);
};

wrapper.treeOnClick = function(event, treeId, node){
    wrapper.addTab(node.menuName, node.menuUrl, node.iconClass);
};

$(wrapper.init);